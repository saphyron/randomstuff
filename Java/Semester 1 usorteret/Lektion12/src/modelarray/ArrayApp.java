package modelarray;

import java.util.Arrays;

public class ArrayApp {

    public static void main(String[] args) {
        ArrayMethods metode = new ArrayMethods();
        int[] array = {4,6,2,4,5};
        System.out.println(metode.sum(array));
        double[] array2 = {2,2,2,2,2};
        System.out.println(metode.sum(array2));
        
        System.out.println("- - - - - - - - - - - - ");
        
        int[] a = {1,2,3,4,5};
        int[] b = {2,2,2};
        System.out.println(Arrays.toString(metode.makeSum(a, b)));
        
        System.out.println("- - - - - - - - - - - - ");
        
        int[] test1 = {1,3,5,7};
        System.out.println(metode.hasUneven(test1));
        int[] test2 = {2,4,6,8};
        System.out.println(metode.hasUneven(test2));
        int[] test3 = {1,3,5,8};
        System.out.println(metode.hasUneven(test3));
        
        /*
        int[] tabel = metode.fyldArrayA();
        System.out.println("Forventet: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = metode.fyldArrayB();
        System.out.println("Forventet: [2, 44, -23, 99, 8, -5, 7, 10, 20, 30]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = metode.fyldArrayC();
        System.out.println("Forventet: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = metode.fyldArrayD();
        System.out.println("Forventet: [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = metode.fyldArrayE();
        System.out.println("Forventet: [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = metode.fyldArrayF();
        System.out.println("Forventet: [0, 1, 0, 1, 0, 1, 0, 1, 0, 1]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = metode.fyldArrayG();
        System.out.println("Forventet: [0, 1, 2, 3 ,4 ,0 ,1 ,2 ,3 ,4]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        // int[] tabel2 = { 78, 23, 1, 4, 65, 3, 87, 5, 12 };
        // metode.printArray(tabel2);
        //
        // System.out.println(metode.findMax(tabel2));
        */
        

    }

}
