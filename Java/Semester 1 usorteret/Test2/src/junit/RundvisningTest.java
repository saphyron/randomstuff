package junit;

import static org.junit.Assert.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Test;

import application.ProduktType;
import application.Rundvisning;

public class RundvisningTest {


	@Test
	public void test() {
		
		ProduktType produktType;
		produktType = new ProduktType("øl");
		new Rundvisning("22 November", LocalDate.of(2019, 11, 22), 
				LocalTime.of(16, 00), produktType);
		
		try {
			new Rundvisning("Test", LocalDate.of(2019, 10, 28), 
					LocalTime.of(12, 15), produktType);
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().equals("Fejl! Rundvisning kan ikke ske før dagens dato."));	
		}	
		try {
			new Rundvisning("Test2", LocalDate.of(2019, 11, 05), 
					LocalTime.of(23, 60), produktType);
			fail("må ikke komme hertil");
		} catch (DateTimeException e) {
			// ok
		}

	}
	
}