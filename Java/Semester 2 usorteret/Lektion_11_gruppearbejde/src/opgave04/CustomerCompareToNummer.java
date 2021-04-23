package opgave04;

import java.util.Comparator;

public class CustomerCompareToNummer implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2) {
//		if (o2.getNumber() == o1.getNumber()) {
//			return 0;
//		} else if (o2.getNumber() > o1.getNumber()) {
//			return 1;
//		} else 
//		return -1;
		
		return Integer.compare(o2.getNumber(), o1.getNumber());
	}

}
