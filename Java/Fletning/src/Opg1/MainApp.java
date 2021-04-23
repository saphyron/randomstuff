package Opg1;

import java.util.ArrayList;

public class MainApp {

	public static void main(String[] args) {
		ArrayList<Customer> l1 = new ArrayList<Customer>();
		ArrayList<Customer> l2 = new ArrayList<Customer>();
		
		ArrayList<Customer> l4 = new ArrayList<Customer>();
		ArrayList<Customer> l5 = new ArrayList<Customer>();

		l1.add(new Customer("Kristian", 28));
		l1.add(new Customer("Børge", 22));
		l1.add(new Customer("Karsten", 27));
		l1.add(new Customer("Katrine", 27));
		l1.add(new Customer("John", 31));
		l1.add(new Customer("Mao", 30));
		l1.add(new Customer("Stalin", 19));
		l1.add(new Customer("John Hitler", 23));
		
		l2.add(new Customer("Mads", 30));
		l2.add(new Customer("Mogens", 10));
		l2.add(new Customer("Middelfart", 50));
		
		
		System.out.println(Opg1.fletAlleKunder(l1, l2));
		
	}

}
