package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.dao.PersonDetailsDao;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;

import java.util.Random;


    @Controller
    public class PersonDetailsController {

        @Autowired
        PersonDetailsDao personDetailsDao;

        @GetMapping("/personDetails/add")
        @ResponseBody
        public String addPersonDetails() {

            Random rand = new Random();
            int i = rand.nextInt(100);

            PersonDetails personDetails = new PersonDetails();
            personDetails.setFirstName("firstName_"+i);
            personDetails.setLastName("lastName_"+i);
            personDetails.setCity("City_"+i);
            personDetails.setStreet("street_"+i);
            personDetails.setStreetNumber(i);


            personDetailsDao.save(personDetails);
            return "person details saved with id: " + personDetails.getId();

        }

        @GetMapping("/personDetails/getById/{id}")
        @ResponseBody
        public String getPersonDetailsById(@PathVariable int id) {
            PersonDetails personDetails = personDetailsDao.findById(id);
            return "person details name is: " + personDetails.getFirstName() + " " + personDetails.getLastName();
        }

        @GetMapping("/personDetails/delete/{id}")
        @ResponseBody
        public String deletePersonDetails(@PathVariable int id) {
            personDetailsDao.delete(id);
            return "person Details deleted";
        }

        @GetMapping("/personDetails/edit/{id}")
        @ResponseBody
        public String editPersonDetails(@PathVariable int id) {
            PersonDetails personDetails = personDetailsDao.findById(id);
            personDetails.setFirstName(personDetails.getFirstName()+"_new");
            personDetails.setLastName(personDetails.getLastName()+"_new");
            personDetailsDao.update(personDetails);
            return "person Details updated";
        }
    }


