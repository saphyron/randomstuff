package model;

/**
 * Klasse der beskriver en ansat
 *
 * @author mad
 *
 */
public class Employee {
	/*
	 * Attributter der beskriver den ansattes tilstand
	 */
	private boolean trainee;
	private int age;
	private String fornavn;
	private String efternavn;
	
	

	/*
	 * Constructor, når den ansatte oprettes, skal den have et navn. Ved
	 * oprettelse er den ansatte en trainee
	 */
	public Employee(String fornavn, String efternavn, int age) {
		this.fornavn = fornavn;
		this.efternavn = efternavn;
		trainee = true;
		this.age = age;
	}

	
	
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	
	public void setEfternavn(String efternavn) {
		this.efternavn = efternavn;
	}

	/*
	 * Man kan få oplyst den ansattes navn, ved at kalde metoden getName
	 */
	public String getName() {
		return fornavn + " " + efternavn;
	}
	
	public String getFornavn() {
		return fornavn;
	}
	
	public String getEftenavn() {
		return efternavn;
	}

	/*
	 * Den ansatte kan få ændret trainee status ved at kalde metoden setTrainess
	 */
	public void setTrainee(boolean trainee) {
		this.trainee = trainee;
	}

	/*
	 * Man kan få oplyst den ansatte er trainess aktivitet, ved at kalde metoden
	 * isTrainee
	 */
	public boolean isTrainee() {
		return trainee;
	}

	public void printEmployee() {
		System.out.println("*******************");
		System.out.println("Name " + fornavn + " " + efternavn);
		System.out.println("Trainee " + trainee);
		System.out.println("Age " + age);
		System.out.println();
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void birthday() {
		age = age + 1;
	}
	
}
