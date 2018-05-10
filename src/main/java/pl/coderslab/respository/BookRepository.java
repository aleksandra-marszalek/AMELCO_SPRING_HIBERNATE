package pl.coderslab.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByTitle(String title);
    List<Book> findAllByAuthors(List<Author> authors);
    List<Book> findAllByAuthorsId(Long authorsId);

    //    Listę książek dla zadanego autora.
//    Listę książek dla zadanego wydawcy
//    Listę książek dla określonego ratingu
//    Pierwszą książkę z zadanej kategorii, z sortowaniem po tytule.


    @Query("Select b From Book b Join b.authors a Where a.id = :authorId")
    List<Book> findAllByAuthorId(@Param("authorId") Long authorId);

    List<Book> findAllByPublisher(Publisher publisher);
    List<Book> findAllByRating(int rating);
    Book findFirstByAuthorsOrderByTitle(Author author);

}
