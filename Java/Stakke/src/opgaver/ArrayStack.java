package opgaver;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayStack implements Stack {

	private Object[] elements;
	private int currentSize;

	public ArrayStack() {
		elements = new Object[5];
		currentSize = 0;
	}

	@Override
	public void push(Object element) {
		if (currentSize < elements.length) {
			elements[currentSize] = element;
			currentSize++;
		} else {
			elements = Arrays.copyOf(elements, elements.length * 2);
			elements[currentSize] = element;
			currentSize++;
		}

	}

	@Override
	public Object pop() {
		if (currentSize == 0) {
			throw new NoSuchElementException("Fejl! Stack er tom!");
		}
		Object result = elements[currentSize - 1];
		elements[currentSize - 1] = null;
		currentSize--;
		return result;
	}

	@Override
	public Object peek() {
		if (elements[currentSize - 1] == null) {
			throw new NoSuchElementException("Fejl! Stack er tom!");
		}
		return elements[currentSize - 1];
	}

	@Override
	public boolean isEmpty() {
		if (currentSize == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		return currentSize;
	}

}
