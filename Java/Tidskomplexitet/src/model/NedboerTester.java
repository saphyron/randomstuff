package model;

public class NedboerTester {

    public static void main(String[] args) {
    	Nedboer n = new Nedboer();
        
        int n1 = n.besteTreFerieUger();
        System.out.println("Bedste tre uger, startuge: " + n1);
        System.out.println("");
        
        int antal = 6;
        int n2 = n.bedsteFerieUgerStart(antal);
        System.out.println("Bedste "+antal+" uger, startuge: " + n2);
        System.out.println("");
        
        System.out.println("Startuge for længste antal uger med ens nedbør: " + 
                n.mestEnsNedboer());
    }
    public int method1(int n){
        int result = 0;
        for (int i = 0; i<n ; i++){
            for (int j = 1; j < n; j = j*2){
                result++;
            }
        }
        return result;
    }


}
