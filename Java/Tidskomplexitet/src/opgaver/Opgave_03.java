package opgaver;

import java.util.Arrays;

public class Opgave_03 {

	public static void main(String[] args) {

		double[] e = { 5, 10, 5, 6, 4, 9, 8 };
		System.out.println("Start Array: " + Arrays.toString(e));
		System.out.println("Correct Array: " + "{5.0, 7.5, 6.667, 6.5, 6.0, 6.5, 6.714}");
		prefixAverage(e);

	}

	public static double[] prefixAverage(double[] inputTal) {
		double count = 0;
		double total = 0;
		for (int i = 0; i < inputTal.length; i++) {
			total = total + inputTal[i];
			count++;
			inputTal[i] = total / count;
		}

		System.out.println();
		System.out.println("Dit array: " + Arrays.toString(inputTal));
		return inputTal;
	}
	
	//O(n)

}
