package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.dao.PersonDetailsDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Person;

import java.util.Random;

@Controller
public class PersonController {

    @Autowired
    PersonDao personDao;

    @Autowired
    PersonDetailsDao personDetailsDao;

    @GetMapping("/person")
    public String add(Model model) {
        model.addAttribute("person", new Person());
        return "PersonForm";
    }

    @PostMapping("/person")
    public String add(@ModelAttribute Person person) {
        personDao.save(person);
        return "PersonForm";
    }

    @GetMapping("/person/add/{personDetailsId}")
    @ResponseBody
    public String addPerson(@PathVariable int personDetailsId) {

        Random rand = new Random();
        int i = rand.nextInt(100);

        Person person = new Person();
        person.setLogin("person_"+i);
        person.setEmail("email_"+i);
        person.setPassword("password_"+i);
        person.setDetails(personDetailsDao.findById(personDetailsId));


        personDao.save(person);
        return "person saved with id: " + person.getId();

    }

    @GetMapping("/person/getById/{id}")
    @ResponseBody
    public String getPersonById(@PathVariable int id) {
        Person person = personDao.findById(id);
        return "person login is: " + person.getLogin().toString();
    }

    @GetMapping("/person/delete/{id}")
    @ResponseBody
    public String deletePerson (@PathVariable int id) {
        personDao.delete(id);
        return "person deleted";
    }

    @GetMapping("/person/edit/{id}")
    @ResponseBody
    public String editPerson (@PathVariable int id) {
        Person person = personDao.findById(id);
        person.setLogin(person.getLogin()+"_new");
        person.setPassword(person.getPassword()+"_new");
        person.setEmail(person.getEmail()+"_new");
        personDao.update(person);
        return "person updated";
    }

}