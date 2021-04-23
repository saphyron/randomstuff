package udlejning;

import java.time.LocalDate;

public class Rental {
	
	private int number;
	private int days;
	private LocalDate startDate;
	private double price;
	public Rental(int number, int days, LocalDate startDate, double price) {
		super();
		this.number = number;
		this.days = days;
		this.startDate = startDate;
		this.price = price;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	
	public double getPricePrDay() {
		return price;
	}
	
	public LocalDate getEndDate() {
		LocalDate date = this.startDate.plusDays(days);
		return date;
	}
	
	public double getTotalPrice() {
		return price * days;
	}

}
