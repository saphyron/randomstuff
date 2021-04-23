package mekaniker;

public class Værkfører extends Mekaniker{
	
	private String udnævelse;
	private double tillæg;
	
	
	public Værkfører(String navn, String addresse, double timeLoenSats, String svendeProeve, String udnævelse, double tillæg) {
		super(navn, addresse, timeLoenSats, svendeProeve);
		this.tillæg = tillæg;
		this.udnævelse = udnævelse;
	}


	public String getUdnævelse() {
		return udnævelse;
	}


	public void setUdnævelse(String udnævelse) {
		this.udnævelse = udnævelse;
	}


	public double getTillæg() {
		return tillæg;
	}


	public void setTillæg(double tillæg) {
		this.tillæg = tillæg;
	}



	
	public double weeklyPay() {
		double totalWeeklyPay = 0;
		totalWeeklyPay = tillæg + super.weeklyPay();
		
		return totalWeeklyPay;
	}
	
	

}
