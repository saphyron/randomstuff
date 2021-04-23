package application;

/**
 * Der skal være mulighed for
 * at registere sig ind i systemet.
 * Klassen bruges til at finde
 * ud af om kunde er berettiget
 * til rabat enten i form af
 * studierabat eller momsfri.
 * 
 * @author gruppe 5
 * @see    Kvittering
 */
public class Kunde implements java.io.Serializable {
	private static final long serialVersionUID = 123123123;
	//Attributter
	private String navn;
	private boolean isStudent;
	private boolean isErhverv;
	private int kundeNr;
	public static int antalKunderTilmeldt = 1;
	
	/**
	 * Skaber en kunde med følgende parameter.
	 * @param navn af kunden.
	 * @param isStudent. Hvis kunden er student. isStudent == true.
	 * @throws IllegalArgumentException hvis kundeNr er negativt.
	 * @throws IllegalArgumentException hvis navn er tom eller null.
	 * @throws IllegalArgumentException hvis kunde er både erhverv og student
	 */
	public Kunde(String navn, boolean isStudent, boolean isErhverv) {
		
		if (navn == null) {
			throw new IllegalArgumentException("Fejl! Kunde instans kan ikke laves: Navn er null");
		}
		
		if (navn.length() == 0) {
			throw new IllegalArgumentException("Fejl! Kunde instans kan ikke laves: Navn er tom");
		}
		
		if (kundeNr < 0) {
			throw new IllegalArgumentException("Fejl! Kunde instans kan ikke laves: KundeNr er negativt");
		}
		
		if (isErhverv == true && isStudent == true) {
			throw new IllegalArgumentException("Fejl! Kunde instans kan ikke laves: Kunde kan ikke både"
					+ "være studerende og erhvervsskunde");
		}
		this.isStudent = isStudent;
		this.navn = navn;
		this.isErhverv = isErhverv;
		kundeNr = Kunde.antalKunderTilmeldt;
		
	}
	/**
	 * Skaber en Gæst kunde.
	 * @param isStudent. Hvis kunden er student. isStudent == true.
	 */
	public Kunde(boolean isStudent) {
		this("Gæst", isStudent,  false);
		kundeNr = 0;
	}
	//Getters og Setters
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public boolean getIsStudent() {
		return isStudent;
	}
	public void setStudent(boolean isStudent) {
		this.isStudent = isStudent;
		isErhverv = false;
	}
	public int getKundeNr() {
		return kundeNr;
	}
	public void setKundeNr(int kundeNr) {
		this.kundeNr = kundeNr;
	}
	
	public boolean isErhverv() {
		return isErhverv;
	}
	public void setErErhverv(boolean erErhverv) {
		this.isErhverv = erErhverv;
		isStudent = false;
	}
	@Override
	public String toString() {
		return navn + " : " + kundeNr;
	}
	/*
	 * Hvis kunden er studerende
	 * eller en hvervskunde skal
	 * der retuneres en streng
	 * som beskriver det.
	 * @return String
	 */
	public String getRabatType() {
		if (isErhverv) {
			return "momsfri";
		}
		else if (isStudent) {
			return "studierabat";
		}
		
		return "";
	}
}
