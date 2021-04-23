package dk.howard.domain;

public class User {
    private final Id id;
    private final Name name;
    private final Age age;
    private final IDen iDen;

    public User(Id id, Name name, Age age, IDen iDen) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.iDen = iDen;
    }

    public Id getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Age getAge() {
        return age;
    }

    public IDen getIDen() {
        return iDen;
    }
}
