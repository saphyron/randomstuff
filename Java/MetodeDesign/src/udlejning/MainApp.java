package udlejning;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MainApp {

	public static void main(String[] args) {
		LocalDate date1;
		LocalDate date2;
		date1 = LocalDate.of(2020, 01, 01);
		date2 = LocalDate.of(2020, 11, 12);
		Rental r1 = new Rental(1, 10, date1, 500);
		Rental r2 = new Rental(1, 10, date2, 500);
		
		System.out.println("Rental 1 cost totally: " + r1.getTotalPrice());
		System.out.println("Rental 2 cost totally: " + r2.getTotalPrice());
		System.out.println("Rental 1 ends at: " + r1.getEndDate());
		System.out.println("Rental 2 ends at: " + r2.getEndDate());
		System.out.println("Rental 1 starts the day after: " + r1.getStartDate().minusDays(1));
		System.out.println("Rental 2 starts the day after: " + r2.getStartDate().minusDays(1));
		
		System.out.println();
		long intervalYears = ChronoUnit.YEARS.between(r1.getStartDate(), r2.getStartDate());
		long intervalMonths = ChronoUnit.MONTHS.between(r1.getStartDate(), r2.getStartDate());
		long intervalDays = ChronoUnit.DAYS.between(r1.getStartDate(), r2.getStartDate());
		System.out.println("Amount of Years between Rental 1 and Rental 2: " + intervalYears);
		System.out.println("Amount of Months between Rental 1 and Rental 2: " + intervalMonths);
		System.out.println("Amount of Days between Rental 1 and Rental 2: " + intervalDays);
	}

}
