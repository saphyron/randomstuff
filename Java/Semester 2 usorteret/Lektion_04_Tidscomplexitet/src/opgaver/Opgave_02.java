package opgaver;

public class Opgave_02 {
	
	//TODO what is the Big O of the following computations?
	
	public int method1 (int n) {
		int result = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j = j * 2) {
				result++;
			}
		}
		return result;
	}
	//O(n)

}
