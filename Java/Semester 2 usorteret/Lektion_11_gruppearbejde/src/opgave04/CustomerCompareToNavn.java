package opgave04;

import java.util.Comparator;

public class CustomerCompareToNavn implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2) {
		return o2.getNavn().compareTo(o1.getNavn());		
	}

}
