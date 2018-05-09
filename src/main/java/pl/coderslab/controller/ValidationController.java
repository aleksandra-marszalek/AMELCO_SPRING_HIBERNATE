package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.Set;

@Controller
public class ValidationController {

    @Autowired
    Validator validator;

    @GetMapping("/validate")
    public String validateBook(Model model) {
        Book book = new Book();
        book.setTitle("test");
        book.setDescription("hello");
        book.setPages(0);


        Set<ConstraintViolation<Book>> valid = validator.validate(book);

        model.addAttribute("valid", valid);
        return "ValidateBook";
    }
}
