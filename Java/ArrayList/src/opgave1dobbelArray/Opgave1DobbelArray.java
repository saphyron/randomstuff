package opgave1dobbelArray;

public class Opgave1DobbelArray {

	public static void main(String[] args) {
		final int ROW = 8;
		final int COL = 8;
		int[][] values = new int[ROW][COL];
		DobbelArray da = new DobbelArray();

		// Udskriv values på tabel form
		da.udskrivArray(values);

		// TODO Opgave 1.1 lav ændringer i values så der står 5 på alle pladser
		int[][] temp = new int[ROW][COL];
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				temp[i][j] = 5;
				values[i][j] = temp[i][j];
			}
		}

		System.out.println();
		System.out.println("Nedenfor skulle der stå 5 på alle pladser");
		System.out.println();
		da.udskrivArray(values);

		// TODO Opgave 1.2 lav ændringer i values så der står 2 i lige rækker og 3 i
		// ulige
		int[][] temp2 = new int[ROW][COL];
		for (int i = 0; i < temp2.length; i++) {
			for (int j = 0; j < temp2[0].length; j++) {
				if (j % 2 == 0) {
					temp2[i][j] = 3;
				} else {
					temp2[i][j] = 2;
				}
				values[i][j] = temp2[i][j];
			}
		}

		System.out.println();
		System.out.println("Nedenfor skulle der stå 2 og 3 på hver anden række");
		System.out.println();
		da.udskrivArray(values);

		// TODO Opgave 1.3 lav ændringer i values så der står 2 i lige søjler og 3 i
		// ulige
		int[][] temp3 = new int[ROW][COL];
		for (int i = 0; i < temp3.length; i++) {
			for (int j = 0; j < temp3[0].length; j++) {
				if (i % 2 == 0) {
					temp3[i][j] = 3;
				} else {
					temp3[i][j] = 2;
				}
				values[i][j] = temp3[i][j];
			}
		}
		System.out.println();
		System.out.println("Nedenfor skulle der stå 2 og 3 på hver anden søjle");
		System.out.println();
		da.udskrivArray(values);

		// TODO Opgave 1.4 lav ændringer i values så den har skiftende 0'er og 1'er
		// som på et
		// skakbræt
		int[][] temp4 = new int[ROW][COL];
		for (int i = 0; i < temp4.length; i++) {
			for (int j = 0; j < temp4.length; j++) {
				temp4[i][j] = (i+j)%2;
                values[i][j] = temp4[i][j];
			}
		}

		System.out.println();
		System.out.println("Nedenfor skulle der stå 0 og 1 på alle pladser som på skakbræt");
		System.out.println();
		da.udskrivArray(values);

		// TODO Opgave 1.5 lav ændringer så alle elementer i nederste og øverste
		// række samt første
		// og sidste søjle er 5 og resten skal være 2.

		System.out.println();
		System.out.println("Nedenfor skulle der stå 5 i kanten og 2 ellers");
		System.out.println();
		da.udskrivArray(values);

		// TODO Opgave 1.6 beregn summen af alle tallene i values og udskriv denne.
	}

}
