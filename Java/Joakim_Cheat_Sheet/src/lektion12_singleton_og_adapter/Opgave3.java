package lektion12_singleton_og_adapter;

public class Opgave3 {

    private int num = 0;

    private static Opgave3 mySingletonIntance;

    private Opgave3() {}

    public static Opgave3 getintance() {
            if (mySingletonIntance == null) {
                    mySingletonIntance = new Opgave3();
            }
            return mySingletonIntance;
    }
    public void count() {num ++;}
    
    public void times2() {
            num *= 2;
    }
    public void zero() {
            num = 0;
    }
    public int getValue() {
            return num;
    }
    
    public void run() {
        Opgave3 mySingleton = Opgave3.getintance();

        mySingleton.count();
        mySingleton.count();
        mySingleton.count();
        mySingleton.times2();

        System.out.println(mySingleton.getValue());

        Opgave3 mySingleTon2 = Opgave3.getintance();
        System.out.println(mySingleTon2.getValue());

        mySingleTon2.times2();

        System.out.println(mySingleton.getValue());

    }
}