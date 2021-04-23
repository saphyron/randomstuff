package opgaver;

import java.util.ArrayList;
import opgaver.Customer;

public class Opgave2_ArrayList {
	
	private static void swap(ArrayList<Customer> list, int i, int j) {
        Customer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
    
    public static void selectionSort(ArrayList<Customer> list) {
        for (int i = 0; i < list.size(); i++) {
            int minPos = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minPos)) > 0) {
                    minPos = j;
                }
                
            }
            swap(list, i, minPos);
        }
    }

}
