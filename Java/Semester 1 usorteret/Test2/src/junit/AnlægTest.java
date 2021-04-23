package junit;

import static org.junit.Assert.*;


import org.junit.Test;

import application.Anlæg;
import application.ProduktType;

public class AnlægTest {
	
	@Test
	public void test() {
		
		ProduktType produktType;
		produktType = new ProduktType("øl");
		
		try {
			new Anlæg("navn", -10.0, produktType);
		} catch (Exception e) {
			assertTrue(e.getMessage().equals("fejl pant må ikke være negativ"));
		}
	}

}
