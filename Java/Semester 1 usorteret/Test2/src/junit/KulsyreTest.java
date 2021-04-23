package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import application.Kulsyre;
import application.ProduktType;

public class KulsyreTest {


	@Test
	public void test() {
		
		ProduktType produktType;
		produktType = new ProduktType("øl");
		Kulsyre kulsyre = new Kulsyre("Kulsyre", 1, 1, produktType);
		
		
		try {
			kulsyre.setVægt(-1);
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("Fejl! Vægten kan ikke være nul eller negativ."));
		}
		
		try {
			kulsyre.setPant(-1);
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("Fejl! Pant kan ikke være negativ."));
		}
	}

}
