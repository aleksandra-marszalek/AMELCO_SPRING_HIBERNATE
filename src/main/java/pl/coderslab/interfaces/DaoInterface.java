package pl.coderslab.interfaces;

import pl.coderslab.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public interface DaoInterface {

//    @PersistenceContext
//    EntityManager em;
//    default void save(Object entity) {
//        em.persist(entity);
//    }
//
//    default void update(Object entity) {
//        em.merge(entity);
//    }
//
//    default Object findById(Long id) {
//        return em.find(Object.class, id);
//    }
//
//    default void delete(Long id) {
//        Object entity = findById(id);
//        em.remove( em.contains(entity) ? entity : em.merge(entity) );
//    }
}
