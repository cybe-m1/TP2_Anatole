package tp2.anatole.personneweb.services;

import tp2.anatole.personneweb.models.Person;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private List<Person> personList = new ArrayList<>(Arrays.asList(
            new Person(1, "de Chauveron", "Anatole"),
            new Person(2, "Lehideux", "Oscar"),
            new Person(3, "Cossard", "Lenny")
    ));

    public List<Person> getAll() {
        return this.personList;
    }

    public Optional<Person> get(int id) {
        return personList
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    public Optional<Person> get_by_name(String name) {
        Optional<Person> person = personList
                .stream()
                .filter(p -> p.getName().equals(name))
                .findFirst();

        return person;
    }

    public Optional<Person> get_by_firstname(String firstname) {
        Optional<Person> person = personList
                .stream()
                .filter(p -> p.getFirstname().equals(firstname))
                .findFirst();

        return person;
    }

    public void create(Person person) {
        this.personList.add(person);
    }

    public void delete(int id) {
        Optional<Person> person_to_delete = Optional.ofNullable(personList.get(id));

        person_to_delete.ifPresent(p -> {
            personList.remove(p);
        });
    }

    public void update(Person person) {
        Optional<Person> person_to_upate = Optional.ofNullable(personList.get(person.getId()));

        person_to_upate.ifPresent(p -> {
            p.setFirstname(person.getFirstname());
            p.setName(person.getName());
        });
    }
}
