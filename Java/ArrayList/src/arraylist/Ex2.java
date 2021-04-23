package arraylist;

import java.util.ArrayList;

public class Ex2 {

    /**
     * Tests all the methods.
     */
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<Integer>();
        ints.add(12);
        ints.add(0);
        ints.add(45);
        ints.add(7);
        ints.add(-16);
        ints.add(0);
        ints.add(23);
        ints.add(-10);
//        ints.addAll(Arrays.asList(12, 0, 45, 7, -16, 0, 23, -10));
        System.out.println("ints: " + ints);
        System.out.println();

        // Test of sum() method: correct sum is 61.
        int total = sum1(ints);
        System.out.println("Sum: " + total);
        // Test of minimum() method: correct minimum is -16.
        System.out.println("Min: " + min(ints));
        // Test of maximum() method: correct maximum is 45.
        System.out.println("Max: " + max(ints));
        // Test of average() method: correct average is 7.625.
        System.out.println("Average: " + average(ints));
        // Test of zeroes() method: correct number of zeroes is 2.
        System.out.println("Amount of Zeroes: " + countZeroes(ints));
        // Test of evens() method: correct result is [12, 0, -16, 0, -10].
        System.out.println("Returns even: " + even(ints));
    }

    // sum made with for statement
    public static int sum1(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int number = list.get(i);
            sum = sum + number;
        }
        return sum;
    }
    public static int min(ArrayList<Integer> list) {
		int mindst = Integer.MAX_VALUE;
		for (Integer i : list) {
			if(mindst > i) {
				mindst = i;
			}
		}
		return mindst;
	}
    public static int max(ArrayList<Integer> list) {
		int max = Integer.MIN_VALUE;
		for (Integer i : list) {
			if(max < i) {
				max = i;
			}
		}
		return max;
	}
    public static double average(ArrayList<Integer> list) {
    	double sum = 0;
    	double total = 0;
    	for (Integer i : list) {
    		sum += i;
    		total++;
    	}
    	return sum / total;
    }
    public static int countZeroes(ArrayList<Integer> list) {
    	int count = 0;
    	for (Integer i : list) {
    		if (i.doubleValue() == 0) {
    			count++;
    		}
    	}
    	return count;
    }
    
    public static String even(ArrayList<Integer> list) {
    	String tests = "";
    	for (Integer i : list) {
    		if (i.doubleValue() % 2 == 0) {
    			tests = tests + i + " ";
    		}
    	}
        return tests;
    }


}
