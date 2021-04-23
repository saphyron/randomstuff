package model;

/*
 * Anvendelses program der opretter Employee objekter og anvender metoder på disse
 */
public class EmployeeApp {

	public static void main(String[] args) {
		Employee e1 = new Employee("Hans", "Jensen", 20);
		e1.printEmployee();
		e1.setFornavn("Viggo");
		e1.setAge(25);
		e1.printEmployee();
		e1.birthday();
		System.out.println(e1.getAge());
		

	}

}
