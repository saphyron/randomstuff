package application;

public class StdRabat implements RabatBehavior, java.io.Serializable {

	/**
	 * Beregner nettopris fra rabat.
	 * @throws IllegalArgumentException hvis kunde er både erhverv og studerende.
	 * @param nettoPris double er nettoprisen.
	 * @param erhverv boolean spørger om kunden er erhvervskunde.
	 * @param studerende boolean spørger om kunden er studerende.
	 * @return nettopris.
	 */
	
	private static final long serialVersionUID = 123123123;
	
	@Override
	public double beregnRabat(double nettoPris, boolean erhverv, boolean studerende) {
		if (erhverv && studerende) {
			throw new IllegalStateException("Kunde kan ikke både være erherv og studerende");
		}
		if (studerende) {
			nettoPris -= nettoPris * 0.1;
		}
		else if (erhverv) {
			nettoPris -= nettoPris * 0.2;
		}
		return nettoPris;
	}
}
