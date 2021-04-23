package mekaniker;

public class Vaerkfoerer extends Mekaniker{
	
	private String udnaevelse;
	private double tillaeg;
	
	
	public Vaerkfoerer(String navn, String addresse, double timeLoenSats, String svendeProeve, String udnaevelse, double tillaeg) {
		super(navn, addresse, timeLoenSats, svendeProeve);
		this.tillaeg = tillaeg;
		this.udnaevelse = udnaevelse;
	}


	public String getudnaevelse() {
		return udnaevelse;
	}


	public void setudnaevelse(String udnaevelse) {
		this.udnaevelse = udnaevelse;
	}


	public double getTillaeg() {
		return tillaeg;
	}


	public void settillaeg(double tillaeg) {
		this.tillaeg = tillaeg;
	}



	
	public double weeklyPay() {
		double totalWeeklyPay = 0;
		totalWeeklyPay = tillaeg + super.weeklyPay();
		
		return totalWeeklyPay;
	}
	
	

}
