
public class UdvidelsesPakke extends TimePakke{
	
	private double plusPris;

	/**
	 * @param mndPris
	 * @param minutPris
	 * @param frieTimer
	 * @param plusPris
	 */
	public UdvidelsesPakke(double mndPris, double minutPris, int frieTimer, double plusPris) {
		super(mndPris, minutPris, frieTimer);
		this.plusPris = plusPris;
	}
	
	@Override
	public double abonnementsPris() {
		return plusPris + super.getMndPris();
	}

	public double getPlusPris() {
		return plusPris;
	}
	
	

}
