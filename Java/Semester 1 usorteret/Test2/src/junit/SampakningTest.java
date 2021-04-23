package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import application.ProduktType;
import application.Sampakning;

public class SampakningTest {

	@Test
	public void test() {
		
		ProduktType produktType;
		produktType = new ProduktType("øl");
		Sampakning sampakning = new Sampakning("navn", 0, 0, produktType);
		
		try {
			sampakning.setAntalGlas(-1);
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("Fejl! Antal glas kan ikke være negativ."));
			
		}
		try {
			sampakning.setAntalØl(-1);
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("Fejl! Antal øl kan ikke være negativ."));
		}
	}

}
