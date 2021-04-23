package fletning;

import java.util.ArrayList;
import java.util.List;

public class FletteSorteringMedTODO {

	// den metode der saetter fletningen i gang
	public void fletteSort(ArrayList<Integer> list) {
		mergesort(list, 0, list.size() - 1);
	}

	// den rekursive metode der implementere del-loes og kombiner skabelonen
	private void mergesort(ArrayList<Integer> list, int l, int h) {
		if (l < h) {
			int m = (l + h) / 2;
			mergesort(list, l, m);
			mergesort(list, m + 1, h);
			System.out.println(list);
			merge(list, l, m, h);
		}
	}

	// kombiner er realiseret ved fletteskabelonen
	private void merge(ArrayList<Integer> list, int low, int middle, int high) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		List<Integer> s1;
		List<Integer> s2;
		
		s1 = new ArrayList<>(list.subList(low, middle + 1));
		s2 = new ArrayList<>(list.subList(middle + 1, high + 1));
		
		int i1 = 0;
		int i2 = 0;
		
		while (i1 < s1.size() && i2 < s2.size()) {
			if(s1.get(i1).compareTo(s2.get(i2)) <= 0) {
				temp.add(s1.get(i1));
				i1++;
			} else {
				temp.add(s2.get(i2));
				i2++;
			}
		}
		
		while (i1 < s1.size()) {
			temp.add(s1.get(i1));
			i1++;
		}
		
		for(int i = 0; i < temp.size();i++) {
			list.set(i + low, temp.get(i));
		}
	}

}
