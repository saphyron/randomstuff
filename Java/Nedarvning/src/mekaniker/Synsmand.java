package mekaniker;

public class Synsmand extends Mekaniker{
	
	private double antalSyn;
	private final double  synstillaeg = 29;
	
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

	public double getSynstillaeg() {
		return synstillaeg;
	}
	
	public double weeklyPay() {
		double totalWeeklyPay = 0;
		totalWeeklyPay = (synstillaeg * antalSyn) + super.weeklyPay();
		
		return totalWeeklyPay;
	}

}
