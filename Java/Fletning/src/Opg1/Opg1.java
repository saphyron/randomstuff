package Opg1;

import java.util.ArrayList;

public class Opg1 {

	public static ArrayList<Customer> fletAlleKunder(ArrayList<Customer> l1, ArrayList<Customer> l2) {
		
		ArrayList<Customer> l3 = new ArrayList<Customer>();
		int i1 = 0;
		int i2 = 0;

		while (i1 < l1.size() && i2 < l2.size()) {
			if (l1.get(i1).getAge() <= l2.get(i2).getAge()) {
				l3.add(l1.get(i1));
				i1++;
			} else {
				l3.add(l2.get(i2));
				i2++;
			}
		}

		while(i1 < l1.size()) {
			l3.add(l1.get(i1));
			i1++;
		}
		
		while(i2 < l2.size()) {
			l3.add(l2.get(i1));
			i2++;
		}
		
		return l3;
			
	}

}

