package model;

public class PersonApp {

    public static void main(String[] args) {
        Person p = new Person("Bent", "Janus", "Christensen", 27, 12, 1990);
        p.printPerson();
        System.out.println("Initialer: " + p.getInit());
        System.out.println("Username: " + p.getUserName());

        System.out.println("Age: " + p.age(18, 9, 2017)); // p's age today
        // int year = 2017;
        // System.out.println("Er " + year + " skudår: " + p.leapYear(year));

    }
}
