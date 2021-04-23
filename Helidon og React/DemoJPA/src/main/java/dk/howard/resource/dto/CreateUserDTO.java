package dk.howard.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserDTO {
    private final String name;
    private final int age;
    private final String iDen;

    @JsonCreator
    public CreateUserDTO(@JsonProperty("name") String name, @JsonProperty("age") int age, @JsonProperty("iDen") String iDen) {
        this.name = name;
        this.age = age;
        this.iDen = iDen;
    }

    public String getName() {
        return name;
    }

    public int getAge() { return age; }

    public String getIDen() { return iDen; }

}
