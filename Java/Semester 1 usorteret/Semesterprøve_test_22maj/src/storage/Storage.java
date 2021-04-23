package storage;

import java.util.ArrayList;
import application.Invalideplads;
import application.Parkeringshus;
import application.Parkeringsplads;
import application.Bil;

public class Storage {
	
	private static ArrayList<Parkeringshus> parkeringshuse = new ArrayList<>();
	private static ArrayList<Bil> biler = new ArrayList<>();
	
	public static ArrayList<Parkeringshus> getParkeringshuse() {
		return new ArrayList<Parkeringshus>(parkeringshuse);
	}
	
	public static void addParkeringshuse(Parkeringshus parkeringshus) {
		parkeringshuse.add(parkeringshus);
	}
	
	public static ArrayList<Bil> getBiler() {
		return new ArrayList<Bil>(biler);
	}
	
	public static void addBiler(Bil bil) {
		biler.add(bil);
	}

}
