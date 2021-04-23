package opgave3;

public class RentalCarApp {

	public static void main(String[] args) {

		Car c1 = new Car("19v JGMH MIA", 2005, 275);
		Car c2 = new Car("19v JGMH KIA", 2007, 316);
		Car c3 = new Car("19v JGMH SIA", 2006, 295);
		Car c4 = new Car("19v JGMH TIA", 2003, 225);
		Car c5 = new Car("19v JGMH XIA", 2002, 195);

		Rental r1 = new Rental(1, 10, "19-03-2019");
		Rental r2 = new Rental(2, 4, "20-03-2019");
		
		r1.addCar(c1);
		r1.addCar(c2);
		r2.addCar(c3);
		r2.addCar(c4);
		r2.addCar(c5);
		
		System.out.println("Rental " + r1.getNumber() + " koster: " + r1.getPrice() + " i laane perioden.");
		System.out.println();
		System.out.println("Rental " + r2.getNumber() + " koster: " + r2.getPrice() + " i laane perioden.");

	}

}
