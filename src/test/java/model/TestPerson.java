package model;

import Persona.Exceptions.ExceptionsPerson;
import Persona.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestPerson {

    @Test
    public void create_successPerson(){
        Person newPerson = Person.create("Juan",
                "Perez",
                LocalDate.of(2000, 1, 1),
                "12.333.444",
                180,
                80);
        Assertions.assertNotNull(newPerson);
    }

    @Test
    public void create_failPersona_Exception_Name(){

        Assertions.assertThrows(ExceptionsPerson.class,
                () -> Person.create("",
                        "Perez",
                        LocalDate.of(2000, 1, 1),
                        "12.333.444",
                        180,
                        80));

        Assertions.assertThrows(ExceptionsPerson.class,
                () -> Person.create(null,
                        "Perez",
                        LocalDate.of(2000, 1, 1),
                        "12.333.444",
                        180,
                        80));
    }

    @Test
    public void create_failPerson_Exceptions_last_name(){
        Assertions.assertThrows(ExceptionsPerson.class,
                () -> Person.create("Juan",
                        "",
                        LocalDate.of(2000, 1, 1),
                        "12.333.444",
                        180,
                        80));

        Assertions.assertThrows(ExceptionsPerson.class,
                () -> Person.create("Juan",
                        null,
                        LocalDate.of(2000, 1, 1),
                        "12.333.444",
                        180,
                        80));
    }

    @Test
    public void create_failPerson_exceptions_document(){
        Assertions.assertThrows(ExceptionsPerson.class,
                () -> Person.create("Juan",
                        "Perez",
                        LocalDate.of(2000, 1, 1),
                        "",
                        180,
                        80));

        Assertions.assertThrows(ExceptionsPerson.class,
                () -> Person.create("Juan",
                        "Perez",
                        LocalDate.of(2000, 1, 1),
                        null,
                        180,
                        80));

    }

    @Test
    public void create_failPerson_Exceptions_height(){
        Assertions.assertThrows(ExceptionsPerson.class,
                () -> Person.create("Juan",
                        "Perez",
                        LocalDate.of(2000, 1, 1),
                        "12.333.444",
                        0,
                        80));

        Assertions.assertThrows(ExceptionsPerson.class,
                () -> Person.create("Juan",
                        "Perez",
                        LocalDate.of(2000, 1, 1),
                        "12.333.444",
                        -100,
                        80));

    }

    @Test
    public void create_failPerson_Exceptions_weight(){
        Assertions.assertThrows(ExceptionsPerson.class,
                () -> Person.create("Juan",
                        "Perez",
                        LocalDate.of(2000, 1, 1),
                        "12.333.444",
                        180,
                        0));

        Assertions.assertThrows(ExceptionsPerson.class,
                () -> Person.create("Juan",
                        "Perez",
                        LocalDate.of(2000, 1, 1),
                        "12.333.444",
                        180,
                        -50));

    }

    @Test
    public void Getters_Person(){
        Person person = new Person("Juan", "Perez",
                LocalDate.of(2000, 1, 1),
                "12.121.121", 180, 80);

        Assertions.assertEquals("Juan", person.getName());
        Assertions.assertEquals("Perez", person.getLast_name());
        Assertions.assertEquals(LocalDate.of(2000, 1, 1), person.getBirthdate());
        Assertions.assertEquals("12.121.121", person.getDocument());
        Assertions.assertEquals(180, person.getHeight());
        Assertions.assertEquals(80, person.getWeight());
    }

    @Test
    public void age_person(){
        Person person = new Person("Juan", "Perez",
                LocalDate.of(2004, 6, 15),
                "12.121.121", 180, 80);

        Assertions.assertEquals(21, person.getAge());
    }

    @Test
    public void person_is_adult() {
        Person person = new Person("Juan", "Perez",
                LocalDate.of(2000, 1, 1),
                "12.121.121", 180, 80);

        Assertions.assertTrue(person.getIsAdult());
    }

    @Test
    public void person_is_not_adult() {
        Person person = new Person("Juan", "Perez",
                LocalDate.of(2020, 1, 1),
                "12.121.121", 180, 80);

        Assertions.assertFalse(person.getIsAdult());
    }
}
