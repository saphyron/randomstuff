package application;

/*
 * Bruges til at kunne specilisere produkt.
 * Fx. en alkohol klasse kan have produktType:
 * Øl, fadøl eller spiritus.
 * 
 * @author Gruppe 5
 * @see Produkt
 * 
 */
public class ProduktType implements Comparable<ProduktType>, java.io.Serializable{
	private static final long serialVersionUID = 123123123;
	private String typeNavn;
	/**
	 * Skaber en produkttype.
	 * @param typeNavn string er navnet for produkttypen.
	 * @throws IllegalArgumentException hvis navn er null eller tom.
	 */
	public ProduktType(String typeNavn) {
		
		if (typeNavn == null) {
			throw new IllegalArgumentException("Fejl! typeNavn er null.");
		}
		
		if (typeNavn.length() == 0) {
			throw new IllegalArgumentException("Fejl! typeNavn er tom.");
		}
		this.typeNavn = typeNavn;
	}

	public String getTypeNavn() {
		return typeNavn;
	}

	@Override
	public int compareTo(ProduktType o) {
		return typeNavn.compareTo(o.getTypeNavn());
	}
	
	public String toString() {
		return typeNavn;
	}
	
}
