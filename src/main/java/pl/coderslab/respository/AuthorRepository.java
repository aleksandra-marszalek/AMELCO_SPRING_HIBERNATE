package pl.coderslab.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findOneByEmail(String email);
    Author findOneByPesel(String pesel);
    List<Author> findAllByLastName(String lastName);

//    Listę autorów, których email zaczyna się od wskazanego ciągu znaków.
//    Listę autorów których pesel zaczyna się od wskazanych znaków, np 83.

    @Query("select a from Author a where a.pesel like :part%")
    List<Author> findAllByPeselStarts(@Param("part") String peselPart);

    @Query("select a from Author a where a.email like :part%")
    List<Author> findAllByEmailStarts(@Param("part") String emailPart);


}
