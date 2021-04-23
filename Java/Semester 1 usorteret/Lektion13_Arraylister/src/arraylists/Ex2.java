package arraylists;

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

        // Test of maximum() method: correct maximum is 45.

        // Test of average() method: correct average is 7.625.

        // Test of zeroes() method: correct number of zeroes is 2.

        // Test of evens() method: correct result is [12, 0, -16, 0, -10].
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

}
