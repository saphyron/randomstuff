package mekaniker;

public class Synsmand extends Mekaniker{
	
	private double antalSyn;
	private final double  synsTill�g = 29;
	
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

	public double getSynsTill�g() {
		return synsTill�g;
	}
	
	public double weeklyPay() {
		double totalWeeklyPay = 0;
		totalWeeklyPay = (synsTill�g * antalSyn) + super.weeklyPay();
		
		return totalWeeklyPay;
	}

}
