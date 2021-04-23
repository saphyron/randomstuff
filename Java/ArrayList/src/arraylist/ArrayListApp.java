package arraylist;

import java.util.ArrayList;

public class ArrayListApp {

	public static void main(String[] args) {
		ArrayList<String> alS = new ArrayList<>();
		alS.add("Hans");
		alS.add("Viggo");
		alS.add("Jens");
		alS.add("Boerge");
		alS.add("Bent");
		
		System.out.println(alS.size());
		System.out.println();
		
		alS.add(1, "Jane");
		for (String s : alS) {
			System.out.print(s + " ");
		}
		System.out.println();
		alS.remove(0);
		alS.add(0, "Pia");
		alS.add("Ib");
		System.out.println(alS.size());
		System.out.println();
		alS.remove(1);
		alS.add(1, "Hansi");
		System.out.println(alS.get(1));
		System.out.println(alS.size());
		System.out.println();
		for (String s : alS) {
			System.out.print(s + " ");
		}
		System.out.println();
		for (int i = 0; i < alS.size(); i++) {
			int sum = 0;
			sum = alS.get(i).length();
			System.out.println(sum);
		}
		System.out.println();
		for (String j: alS) {
			System.out.println(j.length());
		}
	}

}
