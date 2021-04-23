package mekaniker;
import java.util.ArrayList;



public class MainApp {
	
	private static ArrayList<Mekaniker> mekanik = new ArrayList<>();

	public static void main(String[] args) {
		
		Mekaniker m1 = new Mekaniker("John", "landvej 1", 100, "1990");
		Mekaniker m2 = new Vaerkfoerer("S�ren", "Landvej2", 120, "1991", "stuff", 1000);
		Mekaniker m3 = new Synsmand("Stine", "Landsvej 3", 110, "1985", 40);
		
		mekanik.add(m1);
		mekanik.add(m2);
		mekanik.add(m3);
		
		samletLoen(mekanik);

	}
	
	public static double samletLoen(ArrayList<Mekaniker> mekaniks) {
		double totalwage = 0;
		for (Mekaniker mek : mekanik) {
			totalwage = mek.weeklyPay();
			System.out.println(mek.getNavn() + " har tjent: " + totalwage + " kroner i denne uge.");
		}
		return totalwage;
	}

}
