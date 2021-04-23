package application;

import java.util.Comparator;

/**
 * Alfabetisk comparator implementeret af
 * interfacet Comparator. Bruger attributten
 * navn og sammenligner alfabetisk.
 *
 * @author Gruppe 5
 * @see    Pris
 */

public class PrisComparatorAlfabetisk implements Comparator<Pris> , java.io.Serializable {

	private static final long serialVersionUID = 123123123;
	
	@Override
	public int compare(Pris p1, Pris p2) {
		return p1.getProdukt().getNavn().compareTo(p2.getProdukt().getNavn());
	}
	
	@Override
	public String toString() {
		return "Alfabetisk";
	}
}
