package lektion4_tidskompleksitet;

import java.util.Arrays;

public class Opgave_1_5 {
	
	/*
	 * opgave 1
	 */
	
	/*
 		10.1 = O(1)
 		10.2 = O(n)
	 */
	
	/*
	 * opgave 2
	 */
	
	/*
		
	O(n * log n)
	
	*/
	
	/*
	 * Opgave 3
	 */
	
	public static double[] cumulativeAvg(double[] inputArray) {

		int sum = 0;
		int length = inputArray.length;
		double[] outputArray = new double[length];

		for (int i = 0; i < length; i++) {
			sum += inputArray[i];

			outputArray[i] = (double) sum / (i + 1);

		}

		return outputArray;
	}
	
	// tidskompleksiteten er O(n)
	
	/*
	 * opgave 4
	 */
	static private int[] nedbørPrUge = { // 52 uger i alt
			20, 10, 12, 12, 13, 14, 15, 10, 8, 7,
			13, 15, 10, 9, 6, 8, 12, 22, 14, 16, 16,
			18, 23, 12, 0, 2, 0, 0, 78,	0, 0, 0, 34, 12,
			34, 23, 23, 12, 44, 23, 12, 34, 22, 22, 22, 22,
			18, 19, 21, 32, 24, 13 };

	/**
	 * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien, hvis
	 * man ønsker den minimale nedbørsmængde i de tre uger
	 */
	
	// liniær
	public static int besteTreFerieUger() {

		int minRain = Arrays.stream(Arrays.copyOfRange(nedbørPrUge, 0, 3)).sum();
		int minRainDay = 0;
		for (int i = 1; i < nedbørPrUge.length - 2; i++) {

			int rainOfThreeWeeks = Arrays.stream(Arrays.copyOfRange(nedbørPrUge, i, i + 3)).sum();

			if (minRain < rainOfThreeWeeks) {

				minRain = rainOfThreeWeeks;
				minRainDay = i;
			}

		}

		return minRainDay;
	}

	/**
	 * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien, hvis
	 * man ønsker den minimale nedbørsmængde i det antal uger, der er angivet i
	 * parameteren
	 * 
	 * @param antal antal uger man gerne vil holde ferie
	 */
	
	// liniær
	public static int bedsteFerieUgerStart(int antal) {

		int minRain = Arrays.stream(Arrays.copyOfRange(nedbørPrUge, 0, antal)).sum();
		int minRainDay = 0;
		for (int i = antal; i < nedbørPrUge.length - antal; i++) {

			int rainOfThreeWeeks = Arrays.stream(Arrays.copyOfRange(nedbørPrUge, i, i + antal)).sum();

			if (minRain < rainOfThreeWeeks) {

				minRain = rainOfThreeWeeks;
				minRainDay = i;
			}

		}

		return minRainDay;
	}

	/**
	 * Returnerer ugenummeret på den første uge hvor nedbøren har været præcis den
	 * samme flest uger i træk
	 */
	
	// liniær
	public static int mestEnsNedboer() { 

		int currentStreaks = 1;
		int streakStartWeek = 0;
		int maxStreaks = 1;

		for (int i = 1; i < nedbørPrUge.length; i++) {

			if (nedbørPrUge[i] == nedbørPrUge[i - 1]) {
				currentStreaks++;
				streakStartWeek = i - currentStreaks + 2;
			} else {

				if (maxStreaks > currentStreaks)
					maxStreaks = currentStreaks;

				currentStreaks = 1;
			}

		}
		return streakStartWeek;
	}
	
	/*
	 * opgave 5
	 */
	
	public static char[] italienskFlag(char[] italienskFlag) {
		
		int g = 0;
		int h = 0;
		int r = 0;
	
		for (char letter: italienskFlag) {
		
			if (letter == 'G') g++;
			else if (letter == 'H') h++;
			else if (letter == 'R') r++;
	
		}
		
		 char[] output = new char[italienskFlag.length];
		 int i;
		 
		 for (i = 0; i < g; i++) output[i] = 'G';
		 for (i = g; i < g + h; i++) output[i] = 'H';
		 for (i = g + h; i < g + h + r; i++) output[i] = 'R';
		
		 return output;
		
	}
}
