package Persona.Output;

import Persona.model.Person;

public interface PersonByDocumentRepo {
    Person getPerson(String document);
}
