package mekaniker;

public class Mekaniker extends Person {

	private double timeLoenSats;
	private String svendeProeve;
	private final int hoursPerWeek = 37;

	public Mekaniker(String navn, String addresse, double timeLoenSats, String svendeProeve) {
		super(navn, addresse);
		this.svendeProeve = svendeProeve;
		this.timeLoenSats = timeLoenSats;
	}

	public double getTimeLoenSats() {
		return timeLoenSats;
	}

	public void setTimeLoenSats(double timeLoenSats) {
		this.timeLoenSats = timeLoenSats;
	}

	public String getSvendeProeve() {
		return svendeProeve;
	}

	public void setSvendeProeve(String svendeProeve) {
		this.svendeProeve = svendeProeve;
	}
	
	public double weeklyPay() {
		double totalWeeklyPay = 0;
		totalWeeklyPay = this.timeLoenSats * this.hoursPerWeek;
		
		return totalWeeklyPay;
	}
	
	

}
