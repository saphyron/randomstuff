package eksStud;

public class Ekspedient extends Thread {
	
    private TagEtNummer tagEtNummer;  
    
    public Ekspedient(TagEtNummer dims) {
      tagEtNummer = dims;
    }
    
    public void run() {
        while (true) {
            try {
                sleep((int)(Math.random() * 1000));
                tagEtNummer.naesteKunde();
            } catch (InterruptedException e) {
                System.out.println("Exception: " + e.getMessage() );
            }  
        } 
    } 
}
