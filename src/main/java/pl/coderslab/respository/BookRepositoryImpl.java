package pl.coderslab.respository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.coderslab.interfaces.MyRepoCustom;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
@Repository
public class BookRepositoryImpl implements MyRepoCustom {


    @PersistenceUnit
    private EntityManagerFactory emFactory;

    public BookRepositoryImpl() { }



    @Override
    public void resetRating(int rating) {
        EntityManager em = emFactory.createEntityManager();
        Query query = em.createQuery("Update Book a set a.rating=:rating");
        query.setParameter("rating", rating);
        em.joinTransaction();
        query.executeUpdate();
        em.close();
    }
}
