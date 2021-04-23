package arraylister;

import java.util.ArrayList;

public class ArrayListerApp {

	public static void main(String[] args) {
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("Hans");
		list1.add("Viggo");
		list1.add("Jens");
		list1.add("Børge");
		list1.add("Bent");
		
		System.out.println("Der er " + list1.size() + " mennesker i listen");
		System.out.println("- - - - - - - - - - - - - - - - -");
		
		list1.add(2, "Jane");
		System.out.println(list1);
		System.out.println("- - - - - - - - - - - - - - - - -");
		
		list1.remove(1);
		list1.add(0, "Pia");
		list1.add("Ib");
		
		System.out.println(list1);
		System.out.println("- - - - - - - - - - - - - - - - -");
		
		list1.set(2, "Hansi");
		System.out.println("Der er " + list1.size() + " mennesker i listen");
		System.out.println(list1);
		System.out.println("- - - - - - - - - - - - - - - - -");
		
		for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i).length() + " ");
		}
		System.out.println();
		System.out.println("- - - - - - - - - - - - - - - - -");
		
		for (String s : list1) {
			System.out.print(s.length() + " ");
		}

	}

}
