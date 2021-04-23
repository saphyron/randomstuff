package mekaniker;

public class V�rkf�rer extends Mekaniker{
	
	private String udn�velse;
	private double till�g;
	
	
	public V�rkf�rer(String navn, String addresse, double timeLoenSats, String svendeProeve, String udn�velse, double till�g) {
		super(navn, addresse, timeLoenSats, svendeProeve);
		this.till�g = till�g;
		this.udn�velse = udn�velse;
	}


	public String getUdn�velse() {
		return udn�velse;
	}


	public void setUdn�velse(String udn�velse) {
		this.udn�velse = udn�velse;
	}


	public double getTill�g() {
		return till�g;
	}


	public void setTill�g(double till�g) {
		this.till�g = till�g;
	}



	
	public double weeklyPay() {
		double totalWeeklyPay = 0;
		totalWeeklyPay = till�g + super.weeklyPay();
		
		return totalWeeklyPay;
	}
	
	

}
