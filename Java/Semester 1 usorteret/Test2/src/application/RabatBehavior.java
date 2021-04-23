package application;
/**
 * Et interface der beregner nettoprisen fra rabat.
 * @author Gruppe 5
 */
public interface RabatBehavior {
	/**
	 * Beregner nettopris fra rabat.
	 * @param nettoPris double er nettoprisen.
	 * @param erhverv boolean spørger om kunden er erhvervskunde.
	 * @param studerende boolean spørger om kunden er studerende.
	 * @return double.
	 */
	public double beregnRabat(double nettoPris, boolean erhverv, boolean studerende);
}
