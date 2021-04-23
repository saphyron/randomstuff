package arraylister;

import java.util.ArrayList;

public class MethodArrayList {

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
        int minimum = min(ints);
        System.out.println("Minimum value er: " + minimum);

        // Test of maximum() method: correct maximum is 45.

        // Test of average() method: correct average is 7.625.
        double average = average(ints);
        System.out.println("Gennemsnidtet er: " + average);

        // Test of zeroes() method: correct number of zeroes is 2.
        int sum = countZeroes(ints);
        System.out.println("Der er " + sum + " nul taller.");
        
     // Test of evens() method: correct result is [12, 0, -16, 0, -10].
        ArrayList<Integer> test = aEvenList(ints);
        System.out.println(test);
                
        swapEvenWithZero(ints);
        System.out.println(ints);


        
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
    	int minValue = Integer.MAX_VALUE;
    	for (int i = 0; i < list.size(); i++) {
    		if (minValue > list.get(i)) {
    			minValue = list.get(i);
    		}
    	}
    	return minValue;
    }
    
    public static double average(ArrayList<Integer> list) {
    	double sum = 0;
    	for (int i = 0; i < list.size(); i++) {
    		int number = list.get(i);
    		sum = sum + number;
    	}
    	sum = sum / list.size();
    	return sum;
    }
    
    public static int countZeroes(ArrayList<Integer> list) {
    	int sum = 0;
    	for (int i : list) {
    		if (i == 0) {
    			sum++;
    		}
    	}
    	return sum;
    }
    
    public static void swapEvenWithZero(ArrayList<Integer> list) {
    	for (int i = 0; i < list.size(); i++) {
    		int number = list.get(i);
    		if (number % 2 == 0) {
    			list.set(i, 0);
    		}
    	}
    }
    
    public static ArrayList<Integer> aEvenList(ArrayList<Integer> list) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	for (int i = 0; i < list.size(); i++) {
    		int number = list.get(i);
    		if (number % 2 == 0) {
    			result.add(number);
    		}
    	}
    	return result;
    }

}
