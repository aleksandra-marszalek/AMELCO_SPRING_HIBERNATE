package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.interfaces.ValidationProposition;

import javax.validation.Valid;
import javax.validation.groups.Default;
import java.util.List;

@Controller
public class PropositionController {

    @Autowired
    BookDao bookDao;


    @GetMapping("/proposition")
    public String allPropositions(Model model) {
        List<Book> propositions = bookDao.findPropositions();
        model.addAttribute("propositions", propositions);
        return "PropositionList";
    }


    @GetMapping("/proposition/add")
    public String propositionForm(Model model) {
        model.addAttribute("book", new Book());
        return "PropositionForm";
    }

    @PostMapping("/proposition/add")
    public String propositionForm(@Validated({ValidationProposition.class}) @ModelAttribute Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "PropositionForm";
        }
        bookDao.save(book);
        return "redirect:/proposition";
    }

    @GetMapping("/proposition/edit/{id}")
    public String edit(Model model, @PathVariable long id) {
        Book book = bookDao.findById(id);
        model.addAttribute("book", book);
        return "PropositionForm";
    }

    @PostMapping("/proposition/edit/{id}")
    public String edit(@ModelAttribute Book book, @PathVariable long id) {
        bookDao.update(book);
        return "redirect:/proposition";
    }

    @GetMapping("/proposition/delete/{id}")
    public String delete(Model model, @PathVariable long id) {
        Book book = bookDao.findById(id);
        model.addAttribute("book", book);
        return "PropositionDelete";
    }

    @PostMapping("/proposition/delete/{id}")
    public String delete(@ModelAttribute Book book, @PathVariable long id, @RequestParam String agree) {
        if (agree.equals("yes")) {
            bookDao.delete(book.getId());
        }
        return "redirect:/proposition";
    }









    ///////////// MODEL /////////////
    @ModelAttribute("books")
    public List<Book> books() {
        return bookDao.findAll();
    }
}
