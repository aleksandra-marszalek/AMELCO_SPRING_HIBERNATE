package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.entity.Publisher;

import javax.validation.Valid;
import java.util.List;
import java.util.Random;


@Controller
    public class PublisherController {

        @Autowired
        PublisherDao publisherDao;

        @Autowired
    BookDao bookDao;


    @GetMapping("/publisher")
    public String allPublishers(Model model) {
        List<Publisher> publishers = publisherDao.findAll();
        model.addAttribute("publishers", publishers);
        return "PublisherList";
    }

    @GetMapping("/publisher/add")
    public String publisherForm(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "PublisherForm";
    }


    @PostMapping("/publisher/add")
    public String publisherForm(@Valid @ModelAttribute Publisher publisher, BindingResult result) {
        if (result.hasErrors()) {
            return "PublisherForm";
        }
        publisherDao.save(publisher);
        return "redirect:/publisher";
    }

    @GetMapping("/publisher/edit/{id}")
    public String publisher(Model model, @PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        model.addAttribute("publisher", publisher);
        return "PublisherForm";
    }

    @PostMapping("/publisher/edit/{id}")
    public String edit(@ModelAttribute Publisher publisher, @PathVariable long id) {
        publisherDao.update(publisher);
        return "redirect:/publisher";
    }

    @GetMapping("/publisher/delete/{id}")
    public String delete(Model model, @PathVariable long id) {
        Publisher publisher = publisherDao.findById(id);
        model.addAttribute("publisher", publisher);
        return "PublisherDelete";
    }

    @PostMapping("/publisher/delete/{id}")
    public String delete(@ModelAttribute Publisher publisher, @PathVariable long id, @RequestParam String agree) {
        if (agree.equals("yes")) {
            publisherDao.delete(publisher.getId());
        }
        return "redirect:/publisher";
    }

//        @GetMapping("/publisher/add")
//        @ResponseBody
//        public String addPublisher() {
//
//            Random rand = new Random();
//
//            Publisher publisher = new Publisher();
//            publisher.setName("Media Rodzina "+rand.nextInt(100));
//
//
//            publisherDao.save(publisher);
//            return "Publisher saved with id: " + publisher.getId().toString();
//
//        }
//
//        @GetMapping("/publisher/getById/{id}")
//        @ResponseBody
//        public String getPublisherById(@PathVariable long id) {
//            Publisher publisher = publisherDao.findById(id);
//            return "Publisher title is: " + publisher.getName().toString();
//        }
//
//        @GetMapping("/publisher/delete/{id}")
//        @ResponseBody
//        public String deletePublisher (@PathVariable long id) {
//            publisherDao.delete(id);
//            return "Publisher deleted";
//        }
//
//        @GetMapping("/publisher/edit/{id}")
//        @ResponseBody
//        public String editPublisher (@PathVariable long id) {
//            Publisher publisher = publisherDao.findById(id);
//            publisher.setName("Pruszynski i S-ka");
//            publisherDao.update(publisher);
//            return "Publisher updated";
//        }

    ////////// MODEL ATTRIBUTES //////////

    @ModelAttribute("books")
    public List<Book> books() {
        return bookDao.findAll();
    }




}
