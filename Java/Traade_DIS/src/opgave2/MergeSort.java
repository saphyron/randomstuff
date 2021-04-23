package opgave2;

import java.util.*;

public class MergeSort {
// den liste der skal sorteres skal v�re global for de rekursive kald
	private List<Integer> list;

	public MergeSort(List<Integer> list) {
		this.list = list;
	}

	public List<Integer> getList() {
		return list;
	}
	
	public void mergeSort() {
		int l = 0;
		int m = (list.size() - 1) / 2;
		int h = list.size() - 1;
		
		MergeSortThread mst1 = new MergeSortThread(list, l, m);
		MergeSortThread mst2 = new MergeSortThread(list, m + 1, h);
		
		mst1.start();
		mst2.start();
		
		try {
			mst1.join();
			mst2.join();
			
			merge(list, l, m, h);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

//den rekursive metode der implementere del-l�s og kombiner skabelonen
	public void mergeSortHelper(List<Integer> list, int l, int h) {
		if (l < h) {
			int m = (l + h) / 2;
			mergeSortHelper(list, l, m);
			mergeSortHelper(list, m + 1, h);
			merge(list, l, m, h);
		}
	}

// kombiner er realiseret ved fletteskabelonen
	private void merge(List<Integer> list, int low, int middle, int high) {
		List<Integer> temp = new ArrayList<Integer>();
		int i = low;
		int j = middle + 1;
		while (i <= middle && j <= high) {
			if (list.get(i).compareTo(list.get(j)) <= 0) {
				temp.add(list.get(i));
				i++;
			} else {
				temp.add(list.get(j));
				j++;
			}

		}
		while (i <= middle) {
			temp.add(list.get(i));
			i++;
		}
		while (j <= high) {
			temp.add(list.get(j));
			j++;
		}
		for (int k = 0; k < temp.size(); k++) {
			list.set(low + k, temp.get(k));
		}
	}
	
	private class MergeSortThread extends Thread {
		
		List<Integer> list;
		int l;
		int h;
		
		public MergeSortThread(List<Integer> list, int l, int h) {
			this.list = list;
			this.l = l;
			this.h = h;
		}
		
		@Override
		public void run() {
			mergeSortHelper(list, l, h);
		}
	}

}
