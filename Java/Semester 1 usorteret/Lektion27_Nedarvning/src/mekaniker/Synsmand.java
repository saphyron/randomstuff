package mekaniker;

public class Synsmand extends Mekaniker{
	
	private double antalSyn;
	private final double  synsTillæg = 29;
	
	public Synsmand(String navn, String addresse, double timeLoenSats, String svendeProeve, double antalSyn) {
		super(navn, addresse, timeLoenSats, svendeProeve);
		this.antalSyn = antalSyn;
	}

	public double getAntalSyn() {
		return antalSyn;
	}

	public void setAntalSyn(double antalSyn) {
		this.antalSyn = antalSyn;
	}

	public double getSynsTillæg() {
		return synsTillæg;
	}
	
	public double weeklyPay() {
		double totalWeeklyPay = 0;
		totalWeeklyPay = (synsTillæg * antalSyn) + super.weeklyPay();
		
		return totalWeeklyPay;
	}

}
