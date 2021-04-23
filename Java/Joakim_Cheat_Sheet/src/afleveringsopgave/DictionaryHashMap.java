package afleveringsopgave;

import java.util.HashMap;
import java.util.Map;

public class DictionaryHashMap<K, V> implements Dictionary<K, V> {

	private Map<K, V>[] tabel;
	private static int N = 10;
	private int size = 0;

	/**
	 * HashingMap constructor comment.
	 */

	@SuppressWarnings("unchecked")
	public DictionaryHashMap() {
		tabel = new HashMap[N];
		/*
		 * Jeg forestår ikke hvorfor du opfordre til at bruge et array af hashmaps
		 * når opgaven af den grund kan løses som en adapter:
		 * return tabel[key.hashCode() % N].get/put/remove|(K key...) for get put og remove metoden.
		 */
		for (int i = 0; i < N; i++) {
			tabel[i] = new HashMap<K, V>();
		}
	}

	@Override
	public V get(K key) {

		if (key == null) {
			throw new IllegalArgumentException();
		}

		return tabel[key.hashCode() % N].get(key);
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public V put(K key, V value) {

		if (key == null) throw new IllegalArgumentException();
		
		if (value == null) throw new IllegalArgumentException();

		V out = tabel[key.hashCode() % N].put(key, value);

		if (out == null) {
			size++;
		}

		return out;
	}

	@Override
	public V remove(K key) {

		if (key == null) throw new IllegalArgumentException();

		V out = tabel[key.hashCode() % N].remove(key);

		if (out != null) {
			size--;
		}

		return out;
	}

	@Override
	public int size() {
		return size;
	}
	
	public String toString() {
		
		String out = "";
		
		for (int i = 0; i < N; i++) {
			out += "[" + i + "]" + tabel[i] + " ";
		}
		
		return out;
	}

}
