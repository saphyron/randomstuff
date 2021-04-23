/*
 * Ikke færdig!
 */

package lektion24_hashing;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class QuadraticHashTable<K, V> implements Map<K, V> {
	
	private int maxSize;
	private int currentSize;
	private Node[] bucket;
	
	
	public QuadraticHashTable() {
		maxSize = 16;
		currentSize = 0;
		bucket = (Node[]) new Object[maxSize];
	}
	
	public int QuadraticHash(K key) {
		
		int index = key.hashCode() % maxSize;
		
		int counter = 2;
		while(bucket[index] == null) {
			index = (int) Math.pow(key.hashCode(), counter++) % maxSize;
		}
		
		return index;
	}
	
	@Override
	public int size() {
		return currentSize;
	}

	@Override
	public boolean isEmpty() {
		return currentSize == 0;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(Object key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	

	public class Node {
		
		public K key;
		public V value;
		
		
	}
	
	
	
}
