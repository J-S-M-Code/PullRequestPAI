package Persona.UseCase;

import Persona.Exceptions.ExceptionsPerson;
import Persona.Input.PersonByDocumentInput;
import Persona.Output.PersonByDocument;
import Persona.model.Person;

public class GetPersonByDocumentUseCase implements PersonByDocumentInput {

    private PersonByDocument personByDocument;

    public GetPersonByDocumentUseCase(PersonByDocument repo){
        this.personByDocument = repo;
    }

    @Override
    public Person personByDocument(String document) {
        Person person = this.personByDocument.getPerson(document);

        if (person == null) {
            throw new ExceptionsPerson("No existe persona con el documento: " + document);
        }
        return person;
    }
}
