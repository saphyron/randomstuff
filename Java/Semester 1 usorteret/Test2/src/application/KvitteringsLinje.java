package application;

import java.text.DecimalFormat;

/**
 * Holder styr på antal for hver
 * unik pris købt. Der er mulighed
 * en at indstille en 
 * brugerdefineredet for
 * stk. prisen
 * @author Gruppe 5
 * @see    Kvittering 
 *
 */

public class KvitteringsLinje implements java.io.Serializable{
	
	private static final long serialVersionUID = 123123123;
	//Attributter
	private int antal;
	private Pris pris;
	private double stkPris = 0.0;
	
	private double specialAftaltRabat = 0.0;
	/**
	 * Til at skabe en Kvitteringslinje.
	 * @param produkt != null. For at hente et produkts pris.
	 * @param antal 1 til x. For at beskrive hvor mange af et produkt der sælges.
	 * @throws IllegalArgumentException hvis pris er null.
	 * @throws IllegalArgumentException hvis int er negativ eller 0.
	 */
	public KvitteringsLinje(Pris pris, int antal) {
		
		if (pris == null) {
			throw new IllegalArgumentException("Fejl! KvitteringsLinje instans kan ikke laves: Pris er null");
		}
		if (antal < 1) {
			throw new IllegalArgumentException("Fejl! KvitteringsLinje instans kan ikke laves: antal er negativt eller 0");
		}
		
		this.antal = antal;
		this.pris = pris;
		this.stkPris = pris.getStandardPris();
	}
	/**
	 * Variende Rabat for produkt pris
	 * @param antal antal 1 til x. For at beskrive hvor mange af et produkt der sælges.
	 * @param specialAftaltRabat 0.00 til 1.00. Bruges til at regne % rabat per produkt.
	 * @throws IllegalArgumentException hvis rabat er over 1 eller rabat er negativ.
	 */
	public KvitteringsLinje(Pris pris, int antal, double specialAftaltRabat) {
		
		this(pris, antal);
		
		if (specialAftaltRabat < 0 || specialAftaltRabat > 1) {
			throw new IllegalArgumentException("Fejl! KvitteringsLinje instans kan ikke laves:"
					+ " specialAftaltRabat er negativt eller over 100%. Rabat skal være mellem 0% og 100% (inklusivt)");
		}
		
		this.specialAftaltRabat = specialAftaltRabat;
	}

	/**
	 * Setter rabat.
	 * @param specialAftaltPris double der laver rabat.
	 * @throws IllegalArgumentException hvis rabat er negativ.
	 */
	public void setSpeialtAftaltPris(double specialAftaltPris) {
		
		if (specialAftaltPris < 0) {
			throw new IllegalArgumentException("Fejl! KvitteringsLinje metode \'setSpeialtAftaltPris\' kan ikke udføres: prisPrStk er negativt");
		}
		
		stkPris = specialAftaltPris;
		specialAftaltRabat = 0.0;
	}
	
	public double getSpecialAftaltRabat() {
		return specialAftaltRabat;
	}
	/**
	 * Setter rabat.
	 * @param specialAftaltRabat double der laver rabat.
	 * @throws IllegalArgumentException hvis rabat er negativ eller over 1.
	 */
	public void setSpecialAftaltRabat(double specialAftaltRabat) {
		
		if (specialAftaltRabat < 0 || specialAftaltRabat > 1) {
			throw new IllegalArgumentException("Fejl! KvitteringsLinje metode \'setSpecialAftaltRabat\' kan ikke udføres:"
					+ " specialAftaltRabat er negativt eller over 100. Rabat skal være mellem 0 og 100 (inklusivt)");
		}
		this.specialAftaltRabat = specialAftaltRabat;
		stkPris = pris.getStandardPris() - pris.getStandardPris() * specialAftaltRabat;
	}
	
	public int getAntal() {
		return antal;
	}
	
	public void setAntal(int antal) {
		this.antal = antal;
	}
	
	public Pris getPris() {
		return pris;
	}
	
	public void nulstillPrisOgRabat() {
		stkPris = pris.getStandardPris();
		specialAftaltRabat = 0.0;
	}
	
	public double getStkPris() {
		return stkPris;
	}
	
	@Override
	public String toString() {
		String strRabat = "";
		if (specialAftaltRabat != 0.0) {
			strRabat = "(-" + specialAftaltRabat * 100 + "%)";	
		}
		else if(stkPris != pris.getStandardPris()) {
			strRabat = "(før " + pris.getStandardPris() + ")";
		}
		return antal + "x " + new DecimalFormat("#.##").format(stkPris) + " kr " + strRabat + " - " + pris.getProdukt().getNavn();
	}
	
}
