package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.PersonDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Component
    @Transactional
    public class PersonDetailsDao {
        @PersistenceContext
        EntityManager em;
        public void save(PersonDetails personDetails) {
            em.persist(personDetails);
        }

        public void update(PersonDetails personDetails) {
            em.merge(personDetails);
        }

        public PersonDetails findById(int id) {
            return em.find(PersonDetails.class, id);
        }

        public void delete(int id) {
            PersonDetails personDetails = findById(id);
            em.remove( em.contains(personDetails) ? personDetails : em.merge(personDetails) );
        }

    public List<PersonDetails> findAll () {
        Query query = em.createQuery("SELECT a FROM PersonDetails a");
        List<PersonDetails> allPersonDetails = query.getResultList();
        return allPersonDetails;
    }

}
