package lektion5_collections_framework;

import java.util.HashMap;

public class Opgave1 {
	/*
	 * opgave 1
	 */
	
	public void Opgave1() {
		HashMap<String, Integer> myHashMap = new HashMap();
		
		myHashMap.put("en", 34);
		myHashMap.put("to", 12);
		myHashMap.put("tre", 23);
		myHashMap.put("fire", 45);
		myHashMap.put("fem", 67);
		myHashMap.put("seks", 34);
		myHashMap.put("syv", 98);
		
		for (String key : myHashMap.keySet()) {
			System.out.printf("%s %d\n", key, myHashMap.get(key) );
		}
		
		myHashMap.put("otte", 23); System.out.println("23 tilføje!t");
		
		for (String key : myHashMap.keySet()) {
			System.out.printf("%s %d\n", key, myHashMap.get(key) );
		}
		
		myHashMap.remove("fem");
		
		for (String key : myHashMap.keySet()) {
			System.out.printf("%s %d\n", key, myHashMap.get(key) );
		}
		
		System.out.println(myHashMap.containsValue(23));
		System.out.println(myHashMap.size());
	}
	
	/*
	 * opgave 2
	 */
	
}
