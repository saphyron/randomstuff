package eksStud;

public class Bageri {
	
	public static void main(String args[]) {
        System.out.println( "Starter Ekspedient og Kunde tr�dene" );
        TagEtNummer nummerDims = new TagEtNummer();
        Ekspedient ekspedient = new Ekspedient(nummerDims);
        Ekspedient ekspedient2 = new Ekspedient(nummerDims);
        ekspedient.start();
        ekspedient2.start();
        for (int k = 0; k < 100; k++) {
            Kunder kunder = new Kunder(nummerDims);
            kunder.start();
        }
    } 
}
