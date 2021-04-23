package soegningelevopgaver;

import java.util.ArrayList;

public class Soegning {

	//Opgave 1
    public boolean findUlige(int[] tabel) {
        boolean found = false;
        int i = 0;
        while (!found && i < tabel.length) {
        	int k = tabel[i];
        	if (k % 2 != 0) {
        		found = true;
        	} else {
        		i++;
        	}
        }
        if (found) {
        	return found;
        } else {
        	return false;
        }
    }
    //Opgave 2
    public int findInterval(int[] tabel) {
    	boolean found = false;
    	int i = 0;
    	int minInterval = 10;
    	int maxInterval = 15;
    	while (!found && i < tabel.length) {
    		int k = tabel[i];
    		if (k > maxInterval || k < minInterval) {
    			i++;
    		} else {
    			found = true;
    		}
    	}
    	if (found) {
    		return tabel[i];
    	} else {
    		return -1;
    	}
    }
    
    //Opgave 3
    public boolean findToEns(int[] tabel) {
    	boolean found = false;
    	int i = 0;
    	while (!found && i < tabel.length - 1) {
    		int k = tabel[i];
    		int v = tabel[i + 1];
    		if (k == v) {
    			found = true;
    		} else {
    			i++;
    		}
    	}    	
    	if (found) {
        	return found;
        } else {
        	return false;
        }
    }
    
    //Opgave 6
//    public int sorterList(ArrayList<SoegningApp> tabel, int target) {
//    	boolean found = false;
//        int i = 0;
//        ArrayList<SoegningApp> temp = new ArrayList<>();
//        while (!found && i < tabel.size()) {
//        	//int k = tabel.get(i);
//        	if ()
//        }
//    	
//    	return -1;
//    }
}  
