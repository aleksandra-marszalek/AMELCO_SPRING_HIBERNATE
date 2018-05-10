package pl.coderslab.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public interface MyRepoCustom {
    void resetRating(int rating);
}
