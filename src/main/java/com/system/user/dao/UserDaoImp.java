package com.system.user.dao;

import com.system.user.models.User;
import org.hibernate.mapping.UnionSubclass;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @Transactional da la funcionalidad a la clase de poder armar las consultas SQL a la base de datos
 * @Repository hace referencia a la conexión con base de datos
 */
@Repository
@Transactional
public class UserDaoImp implements UserDao {
    @PersistenceContext
    EntityManager entityManager;// ayuda a realizar la conexión a la base de datos

    @Override
    public List<User> getUser() {
        String sql = "FROM User";
        return entityManager.createQuery(sql).getResultList();
    }

    @Override
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void register(User user) {
        entityManager.merge(user);
    }
}