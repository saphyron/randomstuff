package opgaver;

public class Opgave01 {

	private static void swap(String[] list, int i, int j) {
		String temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}

	public static void bubbleSort(String[] list) {
		for (int i = list.length - 1; i >= 0; i--) {
			for (int j = 0; j <= i - 1; j++) {
				if (list[j].compareTo(list[j + 1]) > 0) {
					swap(list, j, j + 1);
				}
			}
		}
	}
}
