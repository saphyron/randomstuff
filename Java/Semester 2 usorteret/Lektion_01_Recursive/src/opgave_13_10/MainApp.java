package opgave_13_10;



public class MainApp {

	public static void main(String[] args) {
		
		int[] e = {10, 20, 17, 15, 13, 7, 9};
		
		System.out.println("Max number is: " + getLargestNumber(e, 0, e[0]) + " vs last number: " + e[e.length - 1]);

	}
	
	public static int getLargestNumber(int[] test, int i, int max) {
		if (i == test.length - 1) {
			return max;
		} else if (max < test[i]) {
			max = test[i];
		}
		
		return getLargestNumber(test, i + 1, max);
	}

	
}
