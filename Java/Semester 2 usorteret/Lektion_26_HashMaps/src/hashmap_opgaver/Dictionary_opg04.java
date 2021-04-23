package hashmap_opgaver;

import java.util.ArrayList;

public class Dictionary_opg04<K, V> implements Dictionary<K, V>{
	
	private int currentSize;
	private ArrayList<Node> v = new ArrayList<>();
	
	/**
	* Returnerer elementet hørende til nøglen k. Hvis nøglen ikke findes,
	* returneres null
	*/
	public V get(K key) {
		
		return null;
	}
	
	/**
	* Returnerer om dictionary er tom.
	*/
	public boolean isEmpty() {
		
		return false;
	}

	/**
	* Indsætter objektet value med nøgle key i dictionary. Hvis key allerede
	* eksisterer, overskrives value hørende til den key, og den gamle value
	* returneres. Hvis key ikke findes, returneres null. Hverken key eller
	* value må være null
	*/
	public V put(K key, V value) {
		
		return null;
	}

	/**
	* Fjerner (nøgle, værdi)-parret med nøglen key fra dictionary'en og
	* value returneres. Hvis key ikke findes, returneres null.
	*/
	public V remove(K key) {
		
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
