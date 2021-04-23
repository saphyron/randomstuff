package dk.howard.repository.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@NamedQueries({
        @NamedQuery(name = "UserTestPO.findByName", query = "SELECT u FROM UserTestPO u where u.userName=:name"),
        @NamedQuery(name = "UserTestPO.findByAge", query = "SELECT u from UserTestPO u where u.age=:age"),
        @NamedQuery(name = "UserTestPO.findByLogin", query = "SELECT u from UserTestPO u where u.name=:name and u.iDen=:iDen")
})
@Entity
@Table(name = "USER_ID_CHAR")
public class UserTestPO {
    public static final String FIND_BY_NAME = "UserTestPO.findByName";
    public static final String NAME_PARAMETER = "name";
    public static final String FIND_BY_AGE = "UserTestPO.findByAge";
    public static final String AGE_PARAMETER = "age";
    public static final String LOGIN_PARAMETER = "name iDen";
    public static final String FIND_BY_LOGIN = "UserTestPO.findByLogin";

    @Id
    @GeneratedValue
    @Column(name = "ID")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "NAME", columnDefinition = "VARCHAR(40)", nullable = false)
    private String userName;

    @Column(name = "AGE", columnDefinition = "int", nullable = false)
    private int age;

    @Column(name = "iDen", columnDefinition = "VARCHAR(40)", nullable = false)
    private String iDen;

    public UserTestPO() {
        //JPA
    }

    public UserTestPO(String userName, int age, String iDen) {

        this.userName = userName;
        this.age = age;
        this.iDen = iDen;
    }

    public UUID getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public int getAge() { return age; }

    public String getIDen() {
        return iDen;
    }
}
