package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.dto.PersonDto;
import pl.coderslab.entity.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Controller
public class PersonDetailController {

    @Autowired
    PersonDto personDto;



    @GetMapping("/personDto")
    public String add(Model model) {
        model.addAttribute("personDto", new PersonDto());
        return "PersonDetailForm";
    }

    @PostMapping("/personDto")
    @ResponseBody
    public String add(@ModelAttribute PersonDto personDto){
        return personDto.toString();
    }


    @ModelAttribute("countryItems")
    public Collection<String> countryItems() {
        List<String> countries = new ArrayList<String>();
        countries.add("Poland");
        countries.add("Usa");
        countries.add("Canada");
        countries.add("China");
        return countries;
    }

    @ModelAttribute("skills")
    public Collection<String> skills() {
        List<String> skills = new ArrayList<String>();
        skills.add("Java");
        skills.add("Php");
        skills.add("python");
        skills.add("ruby");
        return skills;
    }

    @ModelAttribute("hobbies")
    public Collection<String> hobbies() {
        List<String> hobby = new ArrayList<String>();
        hobby.add("skiing");
        hobby.add("cooking");
        hobby.add("running");
        hobby.add("playing frisbee");
        hobby.add("programming");
        return hobby;
    }
}
