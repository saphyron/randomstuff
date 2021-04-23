package opgave3;

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
	
	public int getNumber() {
		return number;
	}

	public void setDays(int days) {
		this.days = days;
	}
	
	public ArrayList<Car> getCar() {
		return new ArrayList<>(cars);
	}
	
	public void addCar(Car car) {
		if(cars.contains(car) != true) {
			cars.add(car);
		}
	}
	
	public void removeCar(Car car) {
		if(cars.contains(car) == true) {
			cars.remove(car);
		}
	}
	
	public double getPrice() {
		double price = 0;
		for (int i = 0; i < cars.size(); i++) {
			price += cars.get(i).getDayPrice() * this.days;
		}
		return price;
	}

}
