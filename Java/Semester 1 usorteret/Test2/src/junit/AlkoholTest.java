package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Alkohol;
import application.ProduktType;

public class AlkoholTest {


	@Test
	public void testAlkohol() {
		
		ProduktType produktType;
		produktType = new ProduktType("øl");
		Alkohol alkohol = new Alkohol("Øl", 0, 1, 0, produktType);
		
		// Try Alkohol Procent %
		try {
			alkohol.setAlkoholProcent(-1);
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("Fejl! Alkohol % kan ikke være negativ."));
		}
		// Try liter L
		try {
			alkohol.setVolume(-1);
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("Fejl! Volume tal kan ikke være negativ."));
		}
		// Try Pant 
		try {
			alkohol.setPant(-1);
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("Fejl! Volume kan ikke være negativ."));
		}
	}
}
