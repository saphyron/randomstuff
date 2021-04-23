package afleveringfravaer;

public class FravaersSystem {
	/**
	 * Fravaerstallene udskrives på skærmen
	 *
	 * @param fravaer
	 */
	public void udskrivFravaer(int[][] fravaer) {
		for (int i = 0; i < fravaer.length; i++) {
			for (int j = 0; j < fravaer[0].length; j++) {
				System.out.print(fravaer[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Returnerer det samlede antal fravaersdage over 12 måneder for eleven med
	 * elevnr.
	 *
	 * @param fravaer
	 * @param elevNr
	 * @return
	 */
	public int samletFravaer(int[][] fravaer, int elevNr) {
		for (int i = 0; i < fravaer.length; i++) {
			int sum = 0;
			if (i == elevNr - 1) {
				for (int j = 0; j < fravaer[0].length; j++) {
					sum = sum + fravaer[i][j];
				}
				System.out.println("Elev nummer " + elevNr + " har haft " + sum + " fraværsdage.");
			}
			
		}
		return -1;
	}

	/**
	 * Returnerer det gennemsnitlige antal fraværsdage pr måned for eleven med
	 * elevNr.
	 *
	 * @param fravaer
	 * @param elevNr
	 * @return
	 */
	public double gennemsnit(int[][] fravaer, int elevNr) {
		for (int i = 0; i < fravaer.length; i++) {
			double gennemsnidt = 0;
			if (i == elevNr - 1) {
				for (int j = 0; j < fravaer[0].length; j++) {
					gennemsnidt = gennemsnidt + fravaer[i][j];
				}
				System.out.println("Elev nummer " + elevNr + " har haft " + (gennemsnidt / 12) + " fraværsdage per måned.");
			}
		}	
		return -1;
	}

	/**
	 * Returnerer antallet af elever, der ikke har haft fravær i de 12 måneder.
	 *
	 * @param fravaer
	 * @return
	 */
	public int antalUdenFravaer(int[][] fravaer) {
		int antalElever = 0;
		for (int i = 0; i < fravaer.length; i++) {
			int sum = 0;

			for (int j = 0; j < fravaer[0].length; j++) {
				sum = sum + fravaer[i][j];
			}
			if (sum == 0) {
				antalElever++;
			}
		}
		if (antalElever == 0) {
			System.out.println("Der er ingen elever der har 0 fraværsdage.");
		} else if (antalElever == 1) {
			System.out.println("Der er " + antalElever + " elev som har 0 fraværsdage.");
		} else {
			System.out.println("Der er " + antalElever + " elever som har 0 fraværsdage.");
		}
		return antalElever;
	}

	/**
	 * Returnerer elevNr for den elev der har haft mest fravær igennem de 12
	 * måneder. Hvis flere elever har haft højst fravær, returneres elevnummer
	 * for en af disse.
	 *
	 * @param fravaer
	 * @return
	 */
	public int mestFravaer(int[][] fravaer) {
		int elevNummer = 0;
		for (int i = 0; i < fravaer.length; i++) {
			int badElev = Integer.MIN_VALUE;
			int sum = 0;
			for (int j = 0; j < fravaer[0].length; j++) {
				sum = sum + fravaer[i][j];
			}
			if (badElev < sum) {
				badElev = sum;
				elevNummer++;
			}
		}
		System.out.println("Elev nummer " + (elevNummer - 1) + " har mest fravær.");
		return -1;
	}

	/**
	 * Registrerer at elenven med elevNr ikke har haft fravær i nogen af de 12
	 * måneder.
	 *
	 * @param fravaer
	 * @param elevNr
	 */
	public void nulstil(int[][] fravaer, int elevNr) {
		fravaer[elevNr - 1 ] = new int[] {0,0,0,0,0,0,0,0,0,0,0,0};
	}
}
