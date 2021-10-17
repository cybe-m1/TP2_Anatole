package tp2.anatole.personneweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import tp2.anatole.personneweb.services.PersonService;
import tp2.anatole.personneweb.models.Person;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/tp2/persons")
public class PersonWebController {
    private PersonService personService;

    @Autowired
    public PersonWebController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String listOfAllPersons(Model model) {
        model.addAttribute("persons", personService.getAll());
        return "index";
    }

    @GetMapping("/{id}")
    public String createPerson(@PathVariable int id, Model model) {
        Person person = personService.get(id).orElse(null);
        if (person == null) {
            return "error";
        }
        model.addAttribute("persons", person);
        return "index";
    }

    @GetMapping("/create")
    public String createPerson(Model model) {
        model.addAttribute("person", new Person());
        return "personForm";
    }

    @PostMapping("/save")
    public String updatePerson(@ModelAttribute Person person, Model model) {
        Optional<Person> optionalPerson = personService.get(person.getId());
        optionalPerson.ifPresentOrElse((
                p -> personService.update(person)), () -> personService.create(person));
        return "redirect:/tp2/persons/" + person.getId();
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable int id, Model model) {
        Optional<Person> person = Optional.ofNullable(personService.get(id).orElse(null));
        if (person == null) {
            return "404";
        }
        personService.delete(id);
        return "redirect:/tp2/persons";
    }

}