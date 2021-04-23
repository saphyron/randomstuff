package application;

import java.util.Comparator;

/**
 * Numerisk (stigende) comparator implementeret af
 * interfacet Comparator. Bruger attributten
 * pris (double).
 *
 * @author Gruppe 5
 * @see    Pris
 */

public class PrisComparatorStkPrisStigende implements Comparator<Pris>, java.io.Serializable{
	
	private static final long serialVersionUID = 123123123;
	
	@Override
	public int compare(Pris p1, Pris p2) {
		return Double.compare(p1.getStandardPris(), p2.getStandardPris());
	}
	
	@Override
	public String toString() {
		return "Pris (stigende)";
	}
}
