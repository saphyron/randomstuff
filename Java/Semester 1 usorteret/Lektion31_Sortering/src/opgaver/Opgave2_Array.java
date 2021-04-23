package opgaver;

public class Opgave2_Array {
	
	private static void swap(String[] list, int i, int j) {
        String temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
    
    public static void selectionSort(String[] list) {
        for (int i = 0; i < list.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j].compareTo(list[minPos]) > 0) {
                    minPos = j;
                }
                
            }
            swap(list, i, minPos);
        }
    }

}
