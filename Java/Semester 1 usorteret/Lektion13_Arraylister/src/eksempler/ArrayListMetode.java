package eksempler;

import java.util.ArrayList;

public class ArrayListMetode {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(2);
		list.add(10);
		list.add(6);
		list.add(8);
		list.add(2);
		
		int sum1 = 0;
		for (int i = 0; i < list.size(); i++) {
			sum1 = sum1 + list.get(i);
		}
		System.out.println("summen er: " + sum1);
		
		sum1 = 0;
		for (int i : list) {
			sum1 = sum1 + i;
		}
		System.out.println("summen er: " + sum1);
		
		System.out.println(hasUneven(list));

	}
	
	public static boolean hasUneven(ArrayList<Integer> list) {
		boolean uneven = false;
		int i = 0;
		while (!uneven && i < list.size()) {
			if (list.get(i) % 2 == 1) {
				uneven = true;
			}
			i++;
		}
		return uneven;
	}

}
