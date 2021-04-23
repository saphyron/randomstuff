package dk.howard.service;

import dk.howard.domain.*;
import dk.howard.repository.Repository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Transactional(rollbackOn = Exception.class)
@Dependent
public class Service {

    private final Repository repository;

    @Inject
    public Service(Repository repository) {
        this.repository = repository;
    }

    public void createUser(Name name, Age age, IDen iDen) {
        repository.createUser(name, age, iDen);
    }

    public List<User> findByName(Name name) {
        return repository.findUserByName(name);
    }

    public List<User> findByAge(Age age) { return repository.findUserByAge(age);}

    public List<User> findUserByLogin(Name name, IDen iDen) {
        return repository.findByLogin(name, iDen);
    }

}
