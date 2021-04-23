package application;

import java.util.Comparator;

/**
 * Numerisk (aftagende) comparator implementeret af
 * interfacet Comparator. Bruger attributten
 * pris (double) .
 *
 * @author Gruppe 5
 * @see    Pris
 */

public class PrisComparatorStkPrisAftagende implements Comparator<Pris>, java.io.Serializable{
	
	private static final long serialVersionUID = 123123123;
	
	@Override
	public int compare(Pris p1, Pris p2) {
		return Double.compare(p2.getStandardPris(), p1.getStandardPris());
	}
	
	@Override
	public String toString() {
		return "Pris (aftagende)";
	}
}
