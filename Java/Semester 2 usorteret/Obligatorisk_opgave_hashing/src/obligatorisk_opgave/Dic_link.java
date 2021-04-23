package obligatorisk_opgave;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Dic_link<K, V> implements Dictionary<K, V>{
	
	private LinkedList<Node> v = new LinkedList<>();
	private int currentSize;

	/**
	* Returnerer elementet hørende til nøglen k. Hvis nøglen ikke findes,
	* returneres null
	*/
	public V get(K key) {
		if (currentSize == 0) {
			throw new NoSuchElementException("Fejl! List er Tom.");
		}
		for (Node n: v) {
			if (n.k.equals(key)) {
				return n.v;
			}
		}
		return null;
	}
	/**
	* Returnerer om dictionary er tom.
	*/
	public boolean isEmpty() {
		if (currentSize == 0) {
			return true;
		}
		return false;
	}
	/**
	* Indsætter objektet value med nøgle key i dictionary. Hvis key allerede
	* eksisterer, overskrives value hørende til den key, og den gamle value
	* returneres. Hvis key ikke findes, returneres null. Hverken key eller
	* value må være null
	*/
	public V put(K key, V value) {
		for (Node n: v) {
			if (n.k.equals(null)) {
				throw new IllegalArgumentException("Fejl! Key kan ikke være null.");
			}
			if (n.v.equals(null)) {
				throw new IllegalArgumentException("Fejl! Value kan ikke være null.");
			}
			if (n.k.equals(key)) {
				Node tempNode = new Node(n.k, n.v);
				V oldValue = tempNode.v;
				n.v = oldValue;
				return tempNode.v;
			}
		}
		Node newNode = new Node(key, value);
		v.add(newNode);
		currentSize++;
		return null;
	}
	/**
	* Fjerner (nøgle, værdi)-parret med nøglen key fra dictionary'en og
	* value returneres. Hvis key ikke findes, returneres null.
	*/
	public V remove(K key) {
		if (currentSize == 0) {
			throw new NoSuchElementException("Fejl! List er Tom.");
		}
		for (Node n: v) {
			if (n.k.equals(key)) {
				Node tempNode = new Node(n.k, n.v);
				v.remove();
				currentSize--;
				return tempNode.v;
			}
		}
		return null;
	}
	/**
	* Returnerer antallet af elementer i dictionary
	*/
	public int size() {
		return currentSize;
	}
	
	public class Node {
		public V v;
		public K k;
		public Node(K key, V value) {
			this.k = key;
			this.v = value;
		}
	}

}
