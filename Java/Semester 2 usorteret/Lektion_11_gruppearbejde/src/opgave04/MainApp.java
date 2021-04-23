package opgave04;

import java.util.ArrayList;
import java.util.Collections;

public class MainApp {

	public static void main(String[] args) {
		ArrayList<Customer> ac1 = new ArrayList<>();
		Customer c1 = new Customer("John", 1, new CustomerCompareToNavn());
		Customer c2 = new Customer("Joakim", 2, new CustomerCompareToNavn());
		Customer c3 = new Customer("Martin", 3, new CustomerCompareToNavn());
		ac1.add(c1);
		ac1.add(c2);
		ac1.add(c3);
		
		Collections.sort(ac1);
		System.out.println("Sorted by name: ");
		System.out.println();
		System.out.println(ac1);
		System.out.println("- - - - - - - - - - -");
		System.out.println();
		
		for (Customer c: ac1) {
			c.setComparator(new CustomerCompareToNummer());
		}
		
		Collections.sort(ac1);
		System.out.println("Sorted by Number: ");
		System.out.println();
		System.out.println(ac1);
		System.out.println("- - - - - - - - - - -");
		System.out.println();
		Collections.reverse(ac1);
		System.out.println("Sorted by name in reverse: ");
		System.out.println();
		System.out.println(ac1);
		System.out.println("- - - - - - - - - - -");
	}

}
