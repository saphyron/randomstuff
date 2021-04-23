package dictionaryelev;

public class DictionaryDemo {

	public static void main(String[] args) {
		//Dictionary dictionary = new DictionaryHashMap<Integer,String>();
		Dictionary<Integer, String> dictionary = new DictionaryLinked<Integer, String>();
		System.out.println("Is list empthy? "+dictionary.isEmpty());
		System.out.println("size: "+dictionary.size());

		dictionary.put(8, "hans");
		dictionary.put(3, "viggo");
		System.out.println(dictionary.get(3));
		System.out.println("Is list empthy? "+dictionary.isEmpty());
		System.out.println("size: "+dictionary.size());

		System.out.println("Person with Key 8 is: " +dictionary.get(8));

		dictionary.put(7, "bent");
		dictionary.put(2, "lene");
		System.out.println("Is list empthy? "+dictionary.isEmpty());
		System.out.println("size: "+dictionary.size());
		System.out.println(dictionary.remove(3));

		System.out.println("size: "+dictionary.size());

		System.out.println(dictionary.put(8, "Ida"));
		System.out.println("Person with Key 8 is: " + dictionary.get(8));

	}
}
