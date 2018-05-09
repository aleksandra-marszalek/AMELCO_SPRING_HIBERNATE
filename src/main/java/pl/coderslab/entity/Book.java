package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotEmpty;
import pl.coderslab.interfaces.ValidationProposition;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=5)
    @NotNull(groups={ValidationProposition.class, Default.class})
    private String title;

    @Min(1)
    @Max(10)
    private int rating;

    @NotEmpty
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Author> authors = new ArrayList<>();

    @NotNull
    @ManyToOne
    private Publisher publisher;

    @Min(1)
    private int pages;


    @Size(max = 600)
    @Column(columnDefinition = "TEXT")
    @NotNull(groups={ValidationProposition.class, Default.class})
    private String description;


    private boolean proposition;

    public Book() {
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isProposition() {
        return proposition;
    }

    public void setProposition(boolean proposition) {
        this.proposition = proposition;
    }
}
