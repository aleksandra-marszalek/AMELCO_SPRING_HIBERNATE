package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class AuthorDao {
    @PersistenceContext
    EntityManager em;
    public void save(Author author) {
        em.persist(author);
    }

    public void update(Author author) {
        em.merge(author);
    }

    public Author findById(Long id) {
        return em.find(Author.class, id);
    }

    public void delete(Long id) {
        Author author = findById(id);
        em.remove( em.contains(author) ? author : em.merge(author) );
    }

    public List<Author> findAll () {
        Query query = em.createQuery("SELECT a FROM Author a");
        List<Author> authors = query.getResultList();
        return authors;
    }

}
