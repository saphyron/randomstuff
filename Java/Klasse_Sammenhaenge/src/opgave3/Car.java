package opgave3;

public class Car {
	private String license;
	private double pricePerDay;
	private int purchaseYear;
	
	public Car(String license, int year, double pricePerDay) {
		this.license = license;
		this.purchaseYear = year;
		this.pricePerDay = pricePerDay;
	}
	
	public void setDayPrice(double price) {
		this.pricePerDay = price;
	}
	
	public double getDayPrice() {
		return pricePerDay;
	}
	
	public String getLicense() {
		return license;
	}
	
	public int getPurchaseYear() {
		return purchaseYear;
	}

}
