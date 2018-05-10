package pl.coderslab.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.interfaces.MyRepoCustom;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>, MyRepoCustom {

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


//
//    metodę wyszukującą książki dla zadanego tytułu.
//    metodę wyszukującą książki dla zadanej kategorii

    @Query("select b From Book b where b.title like:title")
    List<Book> findAllByTitlePart(@Param("title") String titlePart);

    @Query("select b FROM Book b JOIN b.authors a where a in:authors")
    List<Book> findAllForAuthors(@Param("authors") List<Author> authors);

//    Listę książek dla których rating jest pomiędzy zadanymi parametrami np. między 3 a 5.
//
//    Listę książek dla zadanego wydawcy.
//
//    Pierwszą książkę z zadanej kategorii, z sortowaniem po tytule.


    @Query("Select b From Book b where b.rating BETWEEN :low and :high")
    List<Book> findByRatingBetween(@Param("low") int ratingLow, @Param("high") int ratingHigh);

    @Query("Select b From Book b where b.publisher=:publisher")
    List<Book> findAllByPublisherObj (@Param("publisher") Publisher publisher);

    @Query("SELECT b FROM Book b where b.authors=:author ORDER BY b.title")
    List<Book> findFirstByAuthorSortedByName(@Param("author") List<Author>authors);




}
