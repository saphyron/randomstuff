package opgave012;

import java.util.ArrayList;

public class Rental {
	
	private int number;
	private int days;
	private String date;
	private final ArrayList<Car> cars = new ArrayList<>();
	
	public Rental(int number, int days, String date) {
		this.date = date;
		this.days = days;
		this.number = number;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
	
//	public 
//	
//	public double getPrice() {
//		for (int i = 0; i < cars.size(); i++) {
//			
//		}
//	}

}
