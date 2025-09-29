package Persona.Output;

import Persona.model.Person;

public interface SavePersonRepo {
    boolean savePerson(Person person);
    boolean existPerson(String document);
}
