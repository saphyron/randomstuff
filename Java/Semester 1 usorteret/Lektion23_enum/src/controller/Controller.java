package controller;

import java.util.ArrayList;

import application.Plads;
import application.Reservation;
import application.Arrangement;
import storage.Storage;

public class Controller {
	
	public static Arrangement createArrangement(String name, boolean offentlig) {
		Arrangement arrangement = new Arrangement(name, offentlig);
		Storage.addArrangementer(arrangement);
		return arrangement;
	}
	
    public static void initStorage() {
    }

}
