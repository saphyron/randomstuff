package queueopgaver;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * An implementation of a queue as a array.
 */
public class ArrayQueue implements Queue {

	private Object[] elements;
	private int currentSize;

	/**
	 * Constructs an empty queue.
	 */
	public ArrayQueue() {
		elements = new Object[5];
		currentSize = 0;
	}

	/**
	 * Checks whether this queue is empty.
	 *
	 * @return true if this queue is empty
	 */
	@Override
	public boolean isEmpty() {
		if (currentSize == 0) {
			return true;
		} else
			return false;
	}

	/**
	 * Adds an element to the tail of this queue.
	 *
	 * @param newElement the element to add
	 */
	@Override
	public void enqueue(Object newElement) {
		if (currentSize < elements.length) {
			elements[currentSize] = newElement;
			currentSize++;
		} else {
			elements = Arrays.copyOf(elements, elements.length * 2);
			elements[currentSize - 1] = newElement;
			currentSize++;
		}
	}

	/**
	 * Removes an element from the head of this queue.
	 *
	 * @return the removed element
	 */
	@Override
	public Object dequeue() {
		if (currentSize == 0) {
			throw new NoSuchElementException("Fejl! Stack er tom!");
		}
		Object result = elements[currentSize - 1];
		for (int i = 0; i < currentSize -1; i++) {
			elements[i] = elements[i +1];
		}
		elements[currentSize - 1 ] = null;
		currentSize--;
		return result;
	}

	/**
	 * Returns the head of this queue. The queue is unchanged.
	 *
	 * @return the head element
	 */
	@Override
	public Object getFront() {
		if (elements[currentSize - 1] == null) {
			throw new NoSuchElementException("Fejl! Stack er tom!");
		}
		return elements[currentSize - 1];
	}

	/**
	 * The number of elements on the queue.
	 *
	 * @return the number of elements in the queue
	 */
	@Override
	public int size() {
		return currentSize;
	}
}
