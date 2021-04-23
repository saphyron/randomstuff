
public class Abonnement {
	
	private double mndPris;
	private double minutPris;
	/**
	 * @param mndPris
	 * @param minutPris
	 */
	public Abonnement(double mndPris, double minutPris) {
		super();
		this.mndPris = mndPris;
		this.minutPris = minutPris;
	}
	
	public double abonnementsPris() {
		return mndPris;
	}

	public double getMndPris() {
		return mndPris;
	}

	public double getMinutPris() {
		return minutPris;
	}
	
	

}
