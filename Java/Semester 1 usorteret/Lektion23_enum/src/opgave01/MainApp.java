package opgave01;

import java.util.ArrayList;

public class MainApp {
	
	private static ArrayList<Hund> hunde;

	public static void main(String[] args) {
		hunde = new ArrayList<>();
		
		Hund h1 = new Hund("Søren", Race.BOKSER, true, 5000);
		Hund h2 = new Hund("John", Race.BOKSER, false, 3500);
		Hund h3 = new Hund("Kasper", Race.PUDDEL, false, 2500);
		Hund h4 = new Hund("Kasper", Race.PUDDEL, true, 4000);
		Hund h5 = new Hund("Katrine", Race.TERRIER, true, 5500);
		
		hunde.add(h1);
		hunde.add(h2);
		hunde.add(h3);
		hunde.add(h4);
		hunde.add(h5);
		
		System.out.println(samletPris(hunde, Race.BOKSER));
		System.out.println(samletPris(hunde, Race.PUDDEL));
		System.out.println(samletPris(hunde, Race.TERRIER));
	}
	
	public static int samletPris(ArrayList<Hund> hunde, Race race){
		int pris = 0;
		for (Hund hund : hunde) {
			if (hund.getRace() == race) {
				pris += hund.getPris();
			}
		}
		return pris;
	}

}
