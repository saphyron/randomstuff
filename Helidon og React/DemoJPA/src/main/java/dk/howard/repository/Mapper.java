package dk.howard.repository;

import dk.howard.domain.*;
import dk.howard.repository.entity.UserTestPO;

import javax.enterprise.context.Dependent;

@Dependent
public class Mapper {

    public User map(UserTestPO userTestPO) {
        return new User(new Id(userTestPO.getId()), new Name(userTestPO.getUserName()), new Age(userTestPO.getAge()), new IDen(userTestPO.getIDen()));
    }
}
