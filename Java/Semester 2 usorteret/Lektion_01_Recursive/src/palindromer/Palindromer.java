package palindromer;

public class Palindromer {
	
	public boolean isPalindrome(String text) {
		return isPalindrome(text, 0, text.length() - 1);
	}

}
