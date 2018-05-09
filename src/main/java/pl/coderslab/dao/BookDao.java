package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager em;
    public void save(Book book) {
        em.persist(book);
    }

    public void update(Book book) {
        em.merge(book);
    }

    public Book findById(Long id) {
        return em.find(Book.class, id);
    }

    public void delete(Long id) {
        Book book = findById(id);
        em.remove( em.contains(book) ? book : em.merge(book) );
    }

    public List<Book> findAll () {
        Query query = em.createQuery("SELECT a FROM Book a");
        List<Book> allBooks = query.getResultList();
        return allBooks;
    }

    public List<Book> getRatingList(int rating) {
        Query queryp = em.createQuery("SELECT b FROM Book b where rating >:rating");
        queryp.setParameter("rating", 4);
        List<Book> booksp = queryp.getResultList();
        return booksp;
    }

    public List<Book> findPropositions () {
        Query query = em.createQuery("SELECT a From Book a where a.proposition=true");
        List<Book> allBooks = query.getResultList();
        return allBooks;
    }

}