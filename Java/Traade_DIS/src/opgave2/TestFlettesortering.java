package opgave2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestFlettesortering {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Random r=new Random();
		for (int i=0;i<1000000;i++) {
			list.add(Math.abs(r.nextInt()%10000));
		};
		
		//System.out.println(list);
		
		MergeSort sort = new MergeSort(list);
		long l1,l2;
		l1 = System.nanoTime();
		sort.mergeSort();
		l2 = System.nanoTime();
		System.out.println();
		System.out.println("Koeretiden var " + (l2-l1)/1000000);
		System.out.println();
		//System.out.println(list);
	}

}
