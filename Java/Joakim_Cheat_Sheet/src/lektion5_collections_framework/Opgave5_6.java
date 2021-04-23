package lektion5_collections_framework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.nio.charset.StandardCharsets;

import java.util.regex.*;  

public class Opgave5_6 {

	public static void main(String[] args) throws IOException {

	
		String filPlacering = "/test/Gjøngehøvdingen.txt"; //ændre placering efter din fil
		String tekst = new String(Files.readAllBytes(Paths.get(filPlacering)), StandardCharsets.UTF_8);
		List<String> listeAfOrd = string2List(tekst); // en liste af alle ord, indeholder dupletter
		TreeSet<String> setAfOrd = new TreeSet<String>(listeAfOrd); // et set af alle ord i txt-filen
		Map<String, Integer> hyppighedMap = getHyppighedMap(listeAfOrd); // et treemap af alle ord samt deres forekomster
		Map<Integer, List<String>>  SorterethyppighedMap = getSorterethyppighedMap(hyppighedMap); // et treemap men hvor antal forekomster er nøglerne
		
		//printSet(setAfOrd);
		//printMap(hyppighedMap);
		printMap(SorterethyppighedMap);
		  
		
	}
	
	public static List<String> string2List(String tekst) {
		
		tekst = tekst.replaceAll("[^a-zA-ZæøåÆØÅ \n]", ""); // fjerner alle special karakter(er)
		tekst = tekst.replaceAll("\n", " ").toLowerCase(); // konverterer til små bogstav(er)
		
		List<String> listeAfOrd = new ArrayList<String>(List.of(tekst.split(" "))); // deler hvert ord for hvert mellemrum
		
		//while(listeAfOrd.remove("")) {;} // fjerner ordet "" fra listen, dog meget resursekrævende
		
		return listeAfOrd;
	}
	
	public static Map<String, Integer> getHyppighedMap(List<String> listeAfOrd) {
		Map<String, Integer> hyppighedMap = new TreeMap<String, Integer>();
		
		for (String ord : listeAfOrd) {
		    if (hyppighedMap.containsKey(ord)) {
		    	hyppighedMap.put(ord, hyppighedMap.get(ord) + 1);
		    } else {
		    	hyppighedMap.put(ord, 1);
		    }
		}
		
		return hyppighedMap;
	}
	
	public static Map<Integer, List<String>> getSorterethyppighedMap(Map<String, Integer> hyppighedMap) {
		Map<Integer, List<String>> SorterethyppighedMap = new TreeMap<Integer, List<String>>();
		
		for (String key : hyppighedMap.keySet()) {
			
			Integer value = hyppighedMap.get(key);
			
		    if (SorterethyppighedMap.containsKey(value)) {
		    	SorterethyppighedMap.get(value).add(key);
		    } else {
		    	SorterethyppighedMap.put(value , new ArrayList<String>());
		    	SorterethyppighedMap.get(value).add(key);
		    }
		}
		return SorterethyppighedMap; 
	}
	
	public static void printMap(Map map) {
		
		for (Object key : map.keySet()) {
			
			if ((map.get(key)+"").length() > 192)
				System.out.printf("%s -\n%s\n", key, map.get(key));
			else
				System.out.printf("%s - %s\n", key, map.get(key));
		}
	}
	
	public static void printSet(Set set) {
		
		System.out.println("Length of set is: " + set.size());
		
		for (Object value : set) {
			System.out.printf("%s\n", value);
		}
	}
	
}
