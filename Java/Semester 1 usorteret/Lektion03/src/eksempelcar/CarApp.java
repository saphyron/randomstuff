package eksempelcar;

public class CarApp {
    
    public static void main(String[] args) {
        Car myCar = new Car("VW UP", "White");
        System.out.println(myCar.getBrand());
        myCar.setRegistrationNumber("AB 11 123");
        System.out.println(myCar.getRegistrationNumber());
        
        Car minBil = new Car("Ford Escort", "Green");
        System.out.println("**************");
        System.out.println(minBil.getBrand());
        minBil.setRegistrationNumber("9gag 4 life");
        System.out.println(minBil.getRegistrationNumber());
        System.out.println("**************");
        
    }
    
}
