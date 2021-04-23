package opgave04;

import java.util.Comparator;

public class Customer implements Comparable<Customer> {
	
	private String navn;
	private int number;
	private Comparator<Customer> comparator;
	/**
	 * @param navn
	 * @param number
	 */
	public Customer(String navn, int number, Comparator<Customer> comparator) {
		super();
		this.navn = navn;
		this.number = number;
		this.comparator = comparator;
	}
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "[navn=" + navn + ", number=" + number + "]";
	}
	@Override
	public int compareTo(Customer o) {
		return comparator.compare(o, this);
	}
	public Comparator<Customer> getComparator() {
		return comparator;
	}
	public void setComparator(Comparator<Customer> comparator) {
		this.comparator = comparator;
	}
	
	

}
