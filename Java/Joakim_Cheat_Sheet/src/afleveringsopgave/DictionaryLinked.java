package afleveringsopgave;

public class DictionaryLinked<K, V> implements Dictionary<K, V> {

	private Node start;
	private int size;

	/**
	 * HashingMap constructor comment.
	 */

	public DictionaryLinked() {
		// Sentinel (tomt listehoved - der ikke indeholder data)
		start = new Node();
		size = 0;
	}

	@Override
	public V get(K key) {

		if (key == null) {
			throw new IllegalArgumentException();
		}

		Node irter = start;

		while (irter != null) {

			if (irter.key.equals(key)) {
				return irter.value;
			}
			irter = irter.next;
		}

		return null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public V put(K key, V value) {

		if (key == null) throw new IllegalArgumentException();

		if (value == null) throw new IllegalArgumentException();

		if (size == 0) {
			start.key = key;
			start.value = value;
			size++;
			return null;
		}

		Node irter = start;

		while (true) {

			if (irter.key.equals(key)) {
				V oldValue = irter.value;
				irter.value = value;
				return oldValue;
			}

			if (irter.next == null) {
				irter.next = new Node(key, value);
				size++;
				return null;
			}

			irter = irter.next;

		}
	}

	@Override
	public V remove(K key) {

		if (key == null) {
			throw new IllegalArgumentException();
		}

		if (size == 0) {
			return null;
		}

		if (size == 1) {

			if (start.key.equals(key)) {
				V removedValue = start.value;
				start = new Node();
				size--;
				return removedValue;
			} else {
				return null;
			}

		}

		Node irter = start.next;
		Node irterBefore = start;

		while (true) {

			if (irter.key.equals(key)) {
				V removedValue = irter.value;
				irterBefore.next = irter.next;
				size--;
				return removedValue;
			}

			if (irter.next == null) {
				return null;
			}

			irterBefore = irter;
			irter = irter.next;
		}

	}

	@Override
	public int size() {
		return size;
	}

	private class Node {

		public Node next;
		public K key;
		public V value;

		public Node() {
		}

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

	}

	public String toString() {

		String out = "";

		Node irter = start;

		while (irter != null) {
			out += "{" + irter.key + " " + irter.value + "}-";
			irter = irter.next;
		}

		return out.substring(0, out.length() - 1);

	}

}
