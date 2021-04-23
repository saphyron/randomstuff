package strukturAfKlasse;

public class Employee {

	private String name;
	private boolean trainee;

	public Employee(String name) {
		this.name = name;
		trainee = true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void printEmployee() {
		System.out.println("***************");
		System.out.println("Name " + name);
		System.out.println("Trainee " + trainee);
	}

}
