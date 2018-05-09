package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Component
    @Transactional
    public class PublisherDao {
        @PersistenceContext
        EntityManager em;
        public void save(Publisher publisher) {
            em.persist(publisher);
        }

        public void update(Publisher publisher) {
            em.merge(publisher);
        }

        public Publisher findById(Long id) {
            return em.find(Publisher.class, id);
        }

        public void delete(Long id) {
            Publisher publisher = findById(id);
            em.remove( em.contains(publisher) ? publisher : em.merge(publisher) );
        }

    public List<Publisher> findAll () {
        Query query = em.createQuery("SELECT a FROM Publisher a");
        List<Publisher> allPublishers = query.getResultList();
        return allPublishers;
    }

    }