package hashmap_opgaver;

import java.util.HashMap;
import java.util.HashSet;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Bil b = new Bil(registreringsNummer, maerke, model, farve)
		Bil b1 = new Bil("123456", "Skoda", "Octavia", "Sort");
		Bil b2 = new Bil("113456", "Volvo", "b2", "Sort");
		Bil b3 = new Bil("121456", "Ford", "Lort", "Sort");
		Bil b4 = new Bil("123456", "Skoda", "Octavia", "Sort");
		Bil b5 = new Bil("123456", "Ford", "Escort", "Sort");
		Bil b6 = new Bil("123451", "Skoda", "Octavia", "Sort");
		Bil b7 = new Bil("123452", "Skoda", "Octavia", "Sort");
		Bil b8 = new Bil("123451", "Skoda", "Felisia", "Sort");
		Bil b9 = new Bil("123454", "Skoda", "Octavia", "Sort");
		Bil b10 = new Bil("123455", "Skoda", "Octavia", "Sort");
		
		HashSet hs1 = new HashSet<String>();
		hs1.add(b1);
		hs1.add(b2);
		hs1.add(b3);
		hs1.add(b4);
		hs1.add(b5);
		hs1.add(b6);
		hs1.add(b7);
		hs1.add(b8);
		hs1.add(b9);
		hs1.add(b10);
		int tal = 1;
		System.out.println("HashSet Test starter nu: ");
		for (Object s : hs1) {
			System.out.println("Bil " + tal + " :" + s);
			tal++;
			System.out.println();
		}
		
		HashMap<Bil, Integer> hm1 = new HashMap<>();
		hm1.put(b1, 1);
		hm1.put(b2, 2);
		hm1.put(b3, 3);
		hm1.put(b4, 4);
		hm1.put(b5, 5);
		hm1.put(b6, 6);
		hm1.put(b7, 7);
		hm1.put(b8, 8);
		hm1.put(b9, 9);
		hm1.put(b10, 10);
		int tal2 = 1;
		System.out.println("HashMap Test starter nu: ");
		for (Bil key : hm1.keySet()) {
			System.out.println("Bil " + tal2 + ":" + key);
			tal2++;
			System.out.println();
		}
		
		Dictionary_opg03<Integer, Bil> do1 = new Dictionary_opg03<>();
		do1.put(do1.hashvalue(b1.hashCode()), b1);
		int tal3 = 1;
//		for (Bil key : do1) {
//			System.out.println("Bil " + tal3 + ":" + key);
//			tal3++;
//			System.out.println();
//		}

	}
	
	

}
