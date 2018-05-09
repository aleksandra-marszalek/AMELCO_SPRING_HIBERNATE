package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.validation.Valid;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookDao bookDao;

    @Autowired
    PublisherDao publisherDao;

    @Autowired
    AuthorDao authorDao;

    @GetMapping("/book/add")
    public String bookForm(Model model) {
        model.addAttribute("book", new Book());
        return "BookForm";
    }

    @PostMapping("/book/add")
    public String bookForm(@Valid @ModelAttribute Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "BookForm";
        }
        bookDao.save(book);
        return "redirect:/book";
    }

    @GetMapping("/book")
    public String allBooks(Model model) {
        List<Book> books = bookDao.findAll();
        model.addAttribute("books", books);
        return "BookList";
    }

    @GetMapping("/book/edit/{id}")
    public String edit(Model model, @PathVariable long id) {
        Book book = bookDao.findById(id);
        model.addAttribute("book", book);
        return "BookForm";
    }

    @PostMapping("/book/edit/{id}")
    public String edit(@ModelAttribute Book book, @PathVariable long id) {
        bookDao.update(book);
        return "redirect:/book";
    }

    @GetMapping("/book/delete/{id}")
    public String delete(Model model, @PathVariable long id) {
        Book book = bookDao.findById(id);
        model.addAttribute("book", book);
        return "BookDelete";
    }

    @PostMapping("/book/delete/{id}")
    public String delete(@ModelAttribute Book book, @PathVariable long id, @RequestParam String agree) {
        if (agree.equals("yes")) {
            bookDao.delete(book.getId());
        }
        return "redirect:/book";
    }




//    @GetMapping("/book/addBook")
//    @ResponseBody
//    public String addBook() {
//        Publisher publisher = publisherDao.findById(new Long(2));
//
//        List<Author> authors = new ArrayList<>();
//        authors.add(authorDao.findById(new Long(1)));
//        authors.add(authorDao.findById(new Long(2)));
//
//
//        Book book = new Book();
//        book.setTitle("Harry Potter");
//
//
//        book.setPublisher(publisher);
//        book.setAuthors(authors);
//
//
//
//        bookDao.save(book);
//        return "Book saved with id: " + book.getId().toString();
//
//    }
////
//    @GetMapping("/book/getById/{id}")
//    @ResponseBody
//    public String getBookById(@PathVariable long id) {
//        Book book = bookDao.findById(id);
//        return "Book title is: " + book.getTitle().toString();
//    }
//
//    @GetMapping("/book/delete/{id}")
//    @ResponseBody
//    public String deleteBook (@PathVariable long id) {
//        bookDao.delete(id);
//        return "Book deleted";
//    }
//
//    @GetMapping("/book/edit/{id}")
//    @ResponseBody
//    public String editBook (@PathVariable long id) {
//        Book book = bookDao.findById(id);
////        book.setAuthor("J.R.R. Tolkien");
//        book.setTitle("Lord of the Rings");
//        bookDao.update(book);
//        return "Book updated";
//    }


    ////////// MODEL ATTRIBUTES //////////

    @ModelAttribute("publishers")
    public List<Publisher> publishers() {
        return publisherDao.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> authors() {
        return authorDao.findAll();
    }



}
