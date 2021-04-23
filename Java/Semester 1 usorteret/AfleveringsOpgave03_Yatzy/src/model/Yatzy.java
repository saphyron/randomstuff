package model;

import java.util.Random;

public class Yatzy {
	// Face values of the 5 dice.
	// 1 <= values[i] <= 6.
	private int[] values = new int[5];

	// Number of times the 5 dice have been thrown.
	// 0 <= throwCount <= 3.
	private int throwCount = 0;

	// Random number generator.
	private Random random = new Random();

	public Yatzy() {
		//
	}

	/**
	 * Returns the 5 face values of the dice.
	 */
	public int[] getValues() {
		return values;
	}

	/**
	 * Sets the 5 face values of the dice. Req: values contains 5 face values in
	 * [1..6]. Note: This method is only meant to be used for test, and
	 * therefore has package visibility.
	 */
	void setValues(int[] values) {
		this.values = values;
	}

	/**
	 * Returns the number of times the 5 dice has been thrown.
	 */
	public int getThrowCount() {
		return throwCount;
	}

	/**
	 * Resets the throw count.
	 */
	public void resetThrowCount() {
		throwCount = 0;
	}

	/**
	 * Rolls the 5 dice. Only roll dice that are not hold. Req: holds contain 5
	 * boolean values.
	 */
	public void throwDice(boolean[] holds) {
		for (int i = 0; i < values.length; i++) {
			if (!holds[i]) {
				values[i] = random.nextInt(6) + 1;
			}
		}
		throwCount++;
	}

	// -------------------------------------------------------------------------

	/**
	 * Returns all results possible with the current face values. The order of
	 * the results is the same as on the score board. Note: This is an optional
	 * method. Comment this method out, if you don't want use it.
	 */
	public int[] getResults() {
		int[] results = new int[15];
		for (int i = 0; i <= 5; i++) {
			results[i] = this.sameValuePoints(i + 1);
		}
		results[6] = this.onePairPoints();
		results[7] = this.twoPairPoints();
		results[8] = this.threeSamePoints();
		results[9] = this.fourSamePoints();
		results[10] = this.fullHousePoints();
		results[11] = this.smallStraightPoints();
		results[12] = this.largeStraightPoints();
		results[13] = this.chancePoints();
		results[14] = this.yatzyPoints();

		return results;
	}

	// -------------------------------------------------------------------------

	// Returns an int[7] containing the frequency of face values.
	// Frequency at index v is the number of dice with the face value v, 1 <= v
	// <= 6.
	// Index 0 is not used.
	private int[] calcCounts() {
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		int sum4 = 0;
		int sum5 = 0;
		int sum6 = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] == 1) {
				sum1++;
			}
			if (values[i] == 2) {
				sum2++;
			}
			if (values[i] == 3) {
				sum3++;
			}
			if (values[i] == 4) {
				sum4++;
			}
			if (values[i] == 5) {
				sum5++;
			}
			if (values[i] == 6) {
				sum6++;
			}
		}
		int[] frequency = {0, sum1, sum2, sum3, sum4, sum5, sum6};
		return frequency;
	}

	/**
	 * Returns same-value points for the given face value. Returns 0, if no dice
	 * has the given face value. Requires: 1 <= value <= 6;
	 */
	public int sameValuePoints(int value) {
		int sum = 0;
		int[] temp = calcCounts();
		if (1 <= value && value <= 7) {
			sum = temp[value] * value;
			
		}
		return sum;
	}

	/**
	 * Returns points for one pair (for the face value giving highest points).
	 * Returns 0, if there aren't 2 dice with the same face value.
	 */
	public int onePairPoints() {
		int[] temp = calcCounts();
		int sum = 0;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] >= 2) {
				sum = i * 2;
			}
		}
		return sum;
	}

	/**
	 * Returns points for two pairs (for the 2 face values giving highest
	 * points). Returns 0, if there aren't 2 dice with one face value and 2 dice
	 * with a different face value.
	 */
	public int twoPairPoints() {
		int sum = 0;
		int[] temp = calcCounts();
		for (int i = 1; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				if (temp[i] >= 2 && temp[j] >= 2 && i != j) {
					sum = (i * 2) + (j * 2);
				}
			}
		}
		return sum;
	}

	/**
	 * Returns points for 3 of a kind. Returns 0, if there aren't 3 dice with
	 * the same face value.
	 */
	public int threeSamePoints() {
		int[] temp = calcCounts();
		int sum = 0;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] >= 3) {
				sum = i * 3;
			}
		}
		return sum;
	}

	/**
	 * Returns points for 4 of a kind. Returns 0, if there aren't 4 dice with
	 * the same face value.
	 */
	public int fourSamePoints() {
		int[] temp = calcCounts();
		int sum = 0;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] >= 4) {
				sum = i * 4;
			}
		}
		return sum;
	}

	/**
	 * Returns points for full house. Returns 0, if there aren't 3 dice with one
	 * face value and 2 dice a different face value.
	 */
	public int fullHousePoints() {
		int sum = 0;
		int[] temp = calcCounts();
		for (int i = 1; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				if (temp[i] >= 2 && temp[j] >= 3 && i != j) {
					sum = (i * 2) + (j * 3);
				}
			}
		}
		return sum;
	}

	/**
	 * Returns points for small straight. Returns 0, if the dice are not showing
	 * 1,2,3,4,5.
	 */
	public int smallStraightPoints() {
		int sum = 0;
		int[] temp = calcCounts();
		if (temp[1] == 1 && temp[2] == 1 && temp[3] == 1 && temp[4] == 1 && temp[5] == 1) {
			sum = 15;
		}
		return sum;
	}

	/**
	 * Returns points for large straight. Returns 0, if the dice is not showing
	 * 2,3,4,5,6.
	 */
	public int largeStraightPoints() {
		int sum = 0;
		int[] temp = calcCounts();
		if (temp[2] == 1 && temp[3] == 1 && temp[4] == 1 && temp[5] == 1 && temp[6] == 1) {
			sum = 20;
		}
		return sum;
	}

	/**
	 * Returns points for chance.
	 */
	public int chancePoints() {
		int sum = 0;
		for (int i = 0; i < values.length; i++) {
			sum = sum + values[i];
		}
		return sum;
	}

	/**
	 * Returns points for yatzy. Returns 0, if there aren't 5 dice with the same
	 * face value.
	 */
	public int yatzyPoints() {
		int[] temp = calcCounts();
		int sum = 0;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] >= 5) {
				sum = 50;
			}
		}
		return sum;
	}

}
