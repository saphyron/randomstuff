package dk.howard.repository;

import dk.howard.domain.Id;
import dk.howard.domain.Name;
import dk.howard.domain.User;
import dk.howard.domain.Age;
import dk.howard.domain.IDen;
import dk.howard.repository.entity.UserTestPO;
import dk.howard.repository.entitymanager.DemoEntityManager;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
public class Repository {
    private final EntityManager entityManager;
    private final Mapper mapper;

    @Inject
    public Repository(DemoEntityManager entityManager, Mapper mapper) {
        this.entityManager = entityManager.getEntityManager();
        this.mapper = mapper;
    }

    public void createUser(Name name, Age age, IDen iDen) {
        UserTestPO userTestPO = new UserTestPO(name.getName(), age.getAge(), iDen.getIDen());
        entityManager.persist(userTestPO);
    }

    public User findUserById(Id id) {
        UserTestPO po = entityManager.find(UserTestPO.class, id.getId());
        return new User(new Id(po.getId()), new Name(po.getUserName()), new Age(po.getAge()), new IDen(po.getIDen()));
    }

    public List <User> findUserByName(Name name) {
        List <UserTestPO> userTestPOs = findByName(name.getName());
        return userTestPOs.stream().map(u->mapper.map(u)).collect(Collectors.toList());
    }

    public List<User> findUserByAge(Age age) {
        List<UserTestPO> userTestPOs = findByAge(age.getAge());
        return userTestPOs.stream().map(u->mapper.map(u)).collect(Collectors.toList());
    }

    public List<User> findByLogin(Name name, IDen iDen) {
        List<UserTestPO> userTestPOs = findByLogin(name.getName(), iDen.getIDen());
        return userTestPOs.stream().map(u->mapper.map(u)).collect(Collectors.toList());
    }

    private List <UserTestPO> findByName(String name) {

            return entityManager.createNamedQuery(UserTestPO.FIND_BY_NAME, UserTestPO.class)
                    .setParameter(UserTestPO.NAME_PARAMETER, name)
                    .getResultList();

    }

    private List<UserTestPO> findByAge(int age) {
        try {
            return entityManager.createNamedQuery(UserTestPO.FIND_BY_AGE, UserTestPO.class)
                    .setParameter(UserTestPO.AGE_PARAMETER, age)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    private List<UserTestPO> findByLogin(String name, String iDen) {
        try {
            return entityManager.createNamedQuery(UserTestPO.FIND_BY_LOGIN, UserTestPO.class)
                    .setParameter(UserTestPO.NAME_PARAMETER, name).setParameter(UserTestPO.LOGIN_PARAMETER, iDen)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
