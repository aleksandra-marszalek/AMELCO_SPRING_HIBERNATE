package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Component
    @Transactional
    public class PersonDao {
        @PersistenceContext
        EntityManager em;
        public void save(Person person) {
            em.persist(person);
        }

        public void update(Person person) {
            em.merge(person);
        }

        public Person findById(int id) {
            return em.find(Person.class, id);
        }

        public void delete(int id) {
            Person person = findById(id);
            em.remove( em.contains(person) ? person : em.merge(person) );
        }

    public List<Person> findAll () {
        Query query = em.createQuery("SELECT a FROM Person a");
        List<Person> allPersons = query.getResultList();
        return allPersons;
    }

    }