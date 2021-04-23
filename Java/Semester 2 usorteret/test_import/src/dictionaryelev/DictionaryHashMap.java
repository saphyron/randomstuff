package dictionaryelev;

import java.util.HashMap;
import java.util.Map;

public class DictionaryHashMap<K, V> implements Dictionary<K, V> {

	private Map<K, V>[] tabel;
	private static int N = 10;
	private int currentSize = 0;

	/**
	 * HashingMap constructor comment.
	 */

	public DictionaryHashMap() {
		tabel = new HashMap[N];
		for (int i = 0; i < N; i++) {
			tabel[i] = new HashMap<K, V>();
		}
	}

	@Override
	public V get(K key) {
		int i = key.hashCode() % N;
		Map<K, V> m = tabel[i];
		return m.get(key);
	}

	@Override
	public boolean isEmpty() {
		boolean empty = true;
		int i = 0;
		while (empty && i < N) {
			empty = (tabel[i]).isEmpty();
			i++;
		}
		return empty;
	}

	@Override
	public V put(K key, V value) {
		if (key == null || value == null) {
			throw new IllegalArgumentException("Fejl! Key eller Value kan ikke være null.");
		}
		int i = key.hashCode() % N;
		Map<K, V> m = tabel[i];
		if (!m.containsKey(key)) {
			currentSize++;
		}
		return m.put(key, value);
	}

	@Override
	public V remove(K key) {
		if (key == null) {
			throw new IllegalArgumentException("Fejl! Key kan ikke være null.");
		}
		int i = key.hashCode() % N;
		Map<K, V> m = tabel[i];
		if (m.containsKey(key)) {
			currentSize--;
		}
		return m.remove(key);
	}

	@Override
	public int size() {
		return currentSize;
	}

}
