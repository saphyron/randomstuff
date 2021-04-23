package for_loekker;

public class For_loekker {

	public static void main(String[] args) {
		//opgave 2.1
		for (int i = 0; i < 100; i += 2) {
			if (i % 2 == 0) {
				i++;
			}
			System.out.println(i);
		}
		//opgave 2.1 slut
		
		//opgave 2.2
		for (int j = 300; j > 2; j -= 3) {
			System.out.println(j);
		}
		//opgave 2.2 slut
		
		//opgave 5
		int input = 2000;
		for (int prim = 0; prim < input; prim++) {
			int faktor = 2; 
			while (prim % faktor > 0) {
				faktor++;
			}
			if (faktor == prim) {
				System.out.println(prim);
			}
		}
		//opgave 5 slut
	}

}
