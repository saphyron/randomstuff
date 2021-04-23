package application;

/**
 * Denne aktrakte klasse skal repræsentere et produkt skal kan sælges i
 * systemet, prisen er ikke tilknyttet til klassen.
 * @author gruppe 5
 *
 */
abstract public class Produkt implements Comparable<Produkt>, java.io.Serializable {
	
	private static final long serialVersionUID = 123123123;
	private String navn;
	private ProduktType produktType;
	private double gebyr;
	private String gebyrType;
	/**
	 * Skaber et produkt.
	 * @param navn string der er produktets navn.
	 * @param produktType er en associations klasse.
	 * @throws IllegalArgumentException hvis produkt eller produkttype navn er null.
	 * @throws IllegalArgumentException hvis produkt navn er tom.
	 */
	public Produkt(String navn, ProduktType produktType) {
		
		if (navn == null) {
			throw new IllegalArgumentException(String.format("Fejl! Produkt instans kan ikke laves: navn er null."));
		}
		if (navn.length() == 0) {
			throw new IllegalArgumentException(String.format("Fejl! Produkt instans kan ikke laves: navn er tom."));
		}
		if (produktType == null) {
			throw new IllegalArgumentException(String.format("Fejl! Produkt instans kan ikke laves: produktType er null."));
		}
		this.produktType = produktType;
		this.navn = navn;
	}
	
	abstract public String[][] getAttributter();

	public String getNavn() {
		return navn;
	}
	
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	public ProduktType getProduktType() {
		return produktType;
	}
	
	@Override
	public String toString() {
		return navn + " (" + produktType + ")";
	}
	
	public double getGebyr() {
		return gebyr;
	}

	public void setGebyr(double gebyr) {
		this.gebyr = gebyr;
	}

	public String getGebyrType() {
		return gebyrType;
	}

	public void setGebyrType(String gebyrType) {
		this.gebyrType = gebyrType;
	}

	public void setProduktType(ProduktType produktType) {
		this.produktType = produktType;
	}

	@Override
	public int compareTo(Produkt o) {
		return navn.compareTo(o.getNavn());
	}
	
}
