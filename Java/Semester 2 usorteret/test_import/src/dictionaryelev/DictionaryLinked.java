package dictionaryelev;

import java.util.NoSuchElementException;

public class DictionaryLinked<K, V> implements Dictionary<K, V> {

	private Node start;
	private int size;

	/**
	 * HashingMap constructor comment.
	 */

	public DictionaryLinked() {
		// Sentinel (tomt listehoved - der ikke indeholder data)
		size = 0;
	}

	@Override
	public V get(K key) {
		if (isEmpty()) {
			throw new NoSuchElementException("Fejl! List er Tom.");
		}
		Node current = start;
		while (current != null) {
			if (current.key.equals(key)) {
				return current.value;
			}
			current = current.next;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public V put(K key, V value) {
		if (key == null || value == null) {
			throw new IllegalArgumentException("Fejl! Key eller Value kan ikke være null.");
		}
		if (start == null) {
			Node node = new Node();
			node.key = key;
			node.value = value;
			start = node;
			size++;
			return null;
		}
		Node current = start;
		while (current != null) {
			if (current.key.equals(key)) {
				Node tempNode = new Node();
				tempNode.value = current.value;
				V oldValue = tempNode.value;
				current.value = value;
				return oldValue;
			}
			if (current.next == null) {
				Node newNode = new Node();
				newNode.key = key;
				newNode.value = value;
				current.next = newNode;
				size++;
				return null;
			}
			current = current.next;
		}
		return null;
	}

	@Override
	public V remove(K key) {
		if (isEmpty()) {
			throw new NoSuchElementException("Fejl! List er Tom.");
		}
		if (start.key.equals(key)) {
			V oldValue = start.next.value;
			start.next = start.next.next;
			size--;
			return oldValue;
		}

		Node current = start;
		Node previous = null;
		boolean found = false;
		while (current != null && !found) {
			if (current.key.equals(key)) {
				Node tempNode = new Node();
				tempNode.value = current.value;
				found = true;
				current = previous;
				size--;
				return tempNode.value;
			} else {
				previous = current;
				current = current.next;
			}
		}

		return null;
	}

	@Override
	public int size() {
		return size;
	}

	private class Node {
		Node next;
		K key;
		V value;
	}

}
