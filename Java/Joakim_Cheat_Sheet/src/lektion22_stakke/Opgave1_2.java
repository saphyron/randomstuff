package lektion22_stakke;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Opgave1_2 implements Stack {
	
	private LinkedList<Object> linkedlist;
	
	public Opgave1_2() {
		linkedlist = new LinkedList<>();
	}
	
	@Override
	public void push(Object element) {
		linkedlist.addFirst(element);
		
	}

	@Override
	public Object pop() {
		return linkedlist.removeFirst();
	}

	@Override
	public Object peek() {
		return linkedlist.getFirst();
	}

	@Override
	public boolean isEmpty() {
		return linkedlist.isEmpty();
	}

	@Override
	public int size() {
		return linkedlist.size();
	}
	
	public boolean checkParenteses(String s) {
		//s = s.replaceAll("[^{}()\\[\\]]", "");
		
		Map<Character, Character> bracketMap = new HashMap<>();
		
		bracketMap.put(')', '(');
		bracketMap.put(']', '[');
		bracketMap.put('}', '{');
		
		for (char c : s.toCharArray()) {
			
			if (!"{}[]()".contains(""+c)) {
				continue;
			}
			
			if ("{[(".contains(""+c)) {
				push(c);
				continue;
			}
			
			if (isEmpty()) {
				System.err.println("stackUnderflow");
				return false;
			}
			
			if (!pop().equals(bracketMap.get(c))) {
				return false;
			}
		}
		return true;
	}
	
}