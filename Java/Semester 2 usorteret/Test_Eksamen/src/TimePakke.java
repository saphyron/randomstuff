
public class TimePakke extends Abonnement{
	
	private int frieTimer;

	/**
	 * @param mndPris
	 * @param minutPris
	 * @param frieTimer
	 */
	public TimePakke(double mndPris, double minutPris, int frieTimer) {
		super(mndPris, minutPris);
		this.frieTimer = frieTimer;
	}
	
	@Override
	public double abonnementsPris() {
		return super.getMndPris();
	}

	public int getFrieTimer() {
		return frieTimer;
	}

	public void setFrieTimer(int frieTimer) {
		this.frieTimer = frieTimer;
	}


	
	

}
