package opgave01;

import java.util.ArrayList;

public class Car {
	
	private String license;
	private double pricePerDay;
	private int purchaseYear;
	private final ArrayList<Rental> Rentals = new ArrayList<>();
	
	public Car(String license, int year) {
		this.license = license;
		this.purchaseYear = year;
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
