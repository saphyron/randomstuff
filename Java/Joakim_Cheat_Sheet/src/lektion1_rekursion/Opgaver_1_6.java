package lektion1_rekursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Opgaver_1_6 {

	/*
	 * Opgave 1 start
	 */

	/*
	 * E13.1
	 */
	public static int rectangleArea(int x, int y) {

		if (x == 1) {
			return y;
		}

		return y + rectangleArea(x - 1, y);
	}

	/*
	 * E13.10:
	 */
	public static int biggestValueInArray(int[] inputArray) {

		if (inputArray.length == 0) {
			return -1;
		}

		if (inputArray.length == 1) {
			return inputArray[0];
		}

		if (inputArray.length == 2) {
			return Math.max(inputArray[0], inputArray[1]);
		}
		
		inputArray[1] = Math.max(inputArray[0], inputArray[1]);
		return biggestValueInArray(Arrays.copyOfRange(inputArray, 1, inputArray.length));
	}

	/*
	 * E13.11:
	 */
	public static int sumOfArray(int[] inputArray) {
		if (inputArray.length == 0) {
			return 0;
		}

		if (inputArray.length == 1) {
			return inputArray[0];
		}
		
		return inputArray[0] + sumOfArray(Arrays.copyOfRange(inputArray, 1, inputArray.length));
	}
	
	/*
	 * Opgave 1 slut
	 * Opgave 2 start
	 */
	
	/*
	 * delopgave E13.5
	 */
	public static String reverseString(String inputString) {
		
		
		if (inputString.length() == 1) {
			return ""+inputString.charAt(0);
		}
		
		return reverseString(inputString.substring(1, inputString.length())) + inputString.charAt(0);
	}
	
	/*
	 * delopgave E13.6
	 */
	
	public static String reverseString2(String inputString) {
		

		
		return reverseString(inputString.substring(1, inputString.length())) + inputString.charAt(0);
	}
	
	public static String reverseString2(String inputString, int index) {
		
		
		if (index == 0) {
			return ""+inputString.charAt(0);
		}
		
		return inputString.charAt(index) + reverseString2(inputString, index++);
	}
	
	/*
	 * Opgave 2 slut
	 * Opgave 3 start
	 */
	
	public static int power(int n, int p) {
		
		if (p == 0) {
			return 1;
		}
		
		return power(n, p - 1) * n;
	}
	
	
	/*
	 * Opgave 3 slut
	 * Opgave 4 start
	 */
	
	
	public static int sfd(int a, int b) {
		
		if (b <= a && a % b == 0) {
			return b;
		}
		
		if (a < b) {
			return sfd(b, a);
		}
		
		return sfd(b, a % b);
	}
	
	/*
	 * Opgave 4 slut
	 * Opgave 5 start
	 */
	
	private static int irterations;
	private static List<Integer> guesses = new ArrayList<>();
	public static int sqr(int n) {
		
		irterations = 0;
		return sqr(n, 0, 0);
		
	}
	
	public static int sqr(int n, int depth, int padding) {
		
		int guess = (int) Math.pow(2, depth) + padding;
		
		//System.out.println(padding + "+" + guess + "^2 = " +guess * guess);
		
		if (guesses.contains(padding + guess)) {
			//System.out.println("errrr guess is already tryed " + guess);
			return guess;
		} 
				
		guesses.add(padding + guess);
		
		
		
		if (guess * guess == n) {
			return guess;
		}
		
		if (guess * guess > n) {
			return sqr(n, 0, padding + (int) Math.pow(2, depth - 1));
		}
		

		
		
		return sqr(n, depth + 1, padding);
		
		
		
		
		
	}
	
	/*
	 * Opgave 5 slut
	 * Opgave 6 start
	 */
	
	public static int counter;

	public static void domino(int n, String route) {

	    if (n == route.length()) {
	        System.out.println(route);
	        counter ++;
	    }

	    else if (route.length() == n - 1)
	        domino(n, route + '|');
	    else {
	        domino(n, route + '|');
	        domino(n, route + "==");
	    }
	}

	public static int initDomino(int n) {

	    counter = 0;
	    domino(n, "");
	    return counter;
	}
	
	/*
	 * Opgave 6 slut
	 */

}
