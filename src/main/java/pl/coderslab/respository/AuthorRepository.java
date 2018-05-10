package pl.coderslab.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findOneByEmail(String email);
    Author findOneByPesel(String pesel);
    List<Author> findAllByLastName(String lastName);
}
