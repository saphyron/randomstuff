package obligatorisk_opgave;

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

//		HashSet hs1 = new HashSet<String>();
//		hs1.add(b1);
//		hs1.add(b2);
//		hs1.add(b3);
//		hs1.add(b4);
//		hs1.add(b5);
//		hs1.add(b6);
//		hs1.add(b7);
//		hs1.add(b8);
//		hs1.add(b9);
//		hs1.add(b10);
//		int tal = 1;
//		System.out.println("HashSet Test starter nu: ");
//		for (Object s : hs1) {
//			System.out.println("Bil " + tal + " :" + s);
//			tal++;
//			System.out.println();
//		}
//		//--------------
//		HashMap<Bil, Integer> hm1 = new HashMap<>();
//		hm1.put(b1, 1);
//		hm1.put(b2, 2);
//		hm1.put(b3, 3);
//		hm1.put(b4, 4);
//		hm1.put(b5, 5);
//		hm1.put(b6, 6);
//		hm1.put(b7, 7);
//		hm1.put(b8, 8);
//		hm1.put(b9, 9);
//		hm1.put(b10, 10);
//		int tal2 = 1;
//		System.out.println("HashMap Test starter nu: ");
//		for (Bil key : hm1.keySet()) {
//			System.out.println("Bil " + tal2 + ":" + key);
//			tal2++;
//			System.out.println();
//		}

		// --------------
		System.out.println("Dic_link Test starter nu: ");
		Dic_link<Bil, Bil> do1 = new Dic_link<>();
		System.out.println("Størrelsen af list er: " + do1.size());
		System.out.println("Er listen tom? " + do1.isEmpty());
		do1.put(b1, b1);
		do1.put(b2, b2);
		do1.put(b3, b3);
		do1.put(b4, b4);
		do1.put(b5, b5);
		do1.put(b6, b6);
		do1.put(b7, b7);
		do1.put(b8, b8);
		do1.put(b9, b9);
		do1.put(b10, b10);
		System.out.println(do1.get(b1));
		System.out.println();
		System.out.println(do1.get(b2));
		System.out.println();
		System.out.println(do1.get(b3));
		System.out.println();
		System.out.println(do1.get(b4));
		System.out.println();
		System.out.println(do1.get(b5));
		System.out.println();
		System.out.println(do1.get(b6));
		System.out.println();
		System.out.println(do1.get(b7));
		System.out.println();
		System.out.println(do1.get(b8));
		System.out.println();
		System.out.println(do1.get(b9));
		System.out.println();
		System.out.println(do1.get(b10));
		System.out.println();

		System.out.println("Er listen tom? " + do1.isEmpty());
		System.out.println("Størrelsen af list er: " + do1.size());
		System.out.println();
		System.out.println("Remove test: ");
		do1.remove(b1);
		System.out.println("Størrelsen af list er: " + do1.size());
		System.out.println();
		System.out.println(do1.get(b1));
		System.out.println();
		do1.put(b1, b2);
		System.out.println(do1.get(b1));
		System.out.println("Størrelsen af list er: " + do1.size());

	}

}
