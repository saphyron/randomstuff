package dk.howard.resource.dto;

public class UserDTO {
    private final String id;
    private final String name;
    private final int age;
    private final String iDen;

    public UserDTO(String id, String name, int age, String iDen) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.iDen = iDen;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getIDen() { return iDen; }
}
