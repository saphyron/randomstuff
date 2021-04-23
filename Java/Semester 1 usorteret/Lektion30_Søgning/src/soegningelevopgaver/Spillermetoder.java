package soegningelevopgaver;

import java.util.ArrayList;

public class Spillermetoder {
	
	//Opgave 4.1
    public Spiller findScoreLinear(ArrayList<Spiller> spillere, int score) {
        boolean found = false;
        int i = 0;
        while (!found && i < spillere.size()) {
        	if (spillere.get(i).getMaal() == score) {
        		found = true;
        	} else {
        		i++;
        	}
        }
        if (found) {
        	return spillere.get(i);
        } else {
        	return null;
        }
        
    }
    
    //Opgave 4.2
    public Spiller findScoreBinary(ArrayList<Spiller> spillere, int score) {
    	boolean found = false;
		int left = 0;
		int right = spillere.size() - 1;
		int middle = -1;
		while (!found && left <= right){
			middle = (left + right) / 2;
			int k = spillere.get(middle).getMaal();
			if (k == score)
				found = true;
			else if(k > score) {
				right = middle - 1;
			}	
			else {
				left = middle + 1;
			}
		}
		if (found) {
        	return spillere.get(middle);
        } else {
        	return null;
        }
    }

    //Opgave 4.3
    public Spiller findSpillerLineaer(ArrayList<Spiller> spillere) {
    	boolean found = false;
        int i = 0;
        int hoejde = 170;
        int maal = 50;
        while (!found && i < spillere.size()) {
        	if (spillere.get(i).getHoejde() > hoejde && spillere.get(i).getMaal() > maal) {
        		found = true;
        	} else {
        		i++;
        	}
        }
        if (found) {
        	return spillere.get(i);
        } else {
        	return null;
        }
    }

    public static void main(String[] args) {
        Spillermetoder metoder = new Spillermetoder();

        //Opgave 4.1
        ArrayList<Spiller> spillerListe = new ArrayList<>();
        spillerListe.add(new Spiller("Hans", 196, 99, 45));
        spillerListe.add(new Spiller("Bo", 203, 89, 60));
        spillerListe.add(new Spiller("Jens", 188, 109, 32));
        spillerListe.add(new Spiller("Finn", 194, 102, 12));
        spillerListe.add(new Spiller("Lars", 192, 86, 35));
        spillerListe.add(new Spiller("Mads", 200, 103, 37));

        System.out.println("Spiller der har scoret 35 maal: " + metoder.findScoreLinear(spillerListe, 35));
        System.out.println("Spiller der har scoret 30 maal: " + metoder.findScoreLinear(spillerListe, 30));

        //Opgave 4.2
        ArrayList<Spiller> spillerListe2 = new ArrayList<>();
        spillerListe2.add(new Spiller("Bo", 203, 89, 60));
        spillerListe2.add(new Spiller("Hans", 196, 99, 45));
        spillerListe2.add(new Spiller("Mads", 200, 103, 37));
        spillerListe2.add(new Spiller("Lars", 192, 86, 35));
        spillerListe2.add(new Spiller("Jens", 188, 109, 32));
        spillerListe2.add(new Spiller("Finn", 194, 102, 12));
        
        System.out.println("Spiller der har scoret 37 maal: " + metoder.findScoreBinary(spillerListe2, 37));
        System.out.println("Spiller der har scoret 30 maal: " + metoder.findScoreBinary(spillerListe2, 30));

        //Opgave 4.3
        ArrayList<Spiller> spillerListe3 = new ArrayList<>();
        spillerListe3.add(new Spiller("Bo", 203, 89, 60));
        spillerListe3.add(new Spiller("Hans", 196, 99, 45));
        spillerListe3.add(new Spiller("Mads", 200, 103, 37));
        spillerListe3.add(new Spiller("Lars", 192, 86, 35));
        spillerListe3.add(new Spiller("Jens", 188, 109, 32));
        spillerListe3.add(new Spiller("Finn", 194, 102, 12));
        
        System.out.println("Spiller der har scoret +50 maal og er +170 cm hoej: " + metoder.findSpillerLineaer(spillerListe3));
       
    }

}
