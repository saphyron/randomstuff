package eksempelcar;

public class Car {
    private int km;
    private String registrationNumber;
    private String color;
    private String brand;

    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    /**
	 * Gets how many kilometers the car has been running
	 *
	 * @return
	 */
    public int getKm() {
        return this.km;
    }

    /**
	 * Updates how many kilometers the car has been running
	 *
	 * @param km
	 */
    public void setKm(int km) {
        this.km = km;
    }

    /**
	 * Gets the registration number of the car
	 *
	 * @return
	 */
    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    /**
	 * Updates the registration number of the car
	 *
	 * @param registrationNumber
	 */
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    /**
	 * Gets the color of the car
	 *
	 * @return
	 */
    public String getColor() {
        return this.color;
    }

    /**
	 * Updates the color number of the car
	 *
	 * @param color
	 */
    public void setColor(String color) {
        this.color = color;
    }

    /**
	 * Gets the brand of the car
	 *
	 * @return
	 */
    public String getBrand() {
        return this.brand;
    }

}
