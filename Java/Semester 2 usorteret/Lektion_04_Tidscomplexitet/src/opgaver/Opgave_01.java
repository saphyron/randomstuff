package opgaver;

public class Opgave_01 {
	
	//TODO what is the Big O of the following computations?
	
	boolean isStringHello(String string) {
		if(string.equals ("Hello")) {
			return true;
		}
		return false;
	}
	// O(1)
	
	boolean checkString(String[] strings, String st) {
		for (int i = 0; i < strings.length; i++) {
			if (strings[i] == st) {
				return true;
			}
		}
		return false;
	}
	// O(n)

}
