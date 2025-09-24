package model;

import Persona.Exceptions.ExceptionsPerson;
import Persona.Output.PersonByDocument;
import Persona.UseCase.GetPersonByDocumentUseCase;
import Persona.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonByDocumentTest {
    @Mock
    PersonByDocument repo;
    @InjectMocks
    GetPersonByDocumentUseCase useCase;

    @Test
    void person_by_document(){
        when(repo.getPerson("123456789")).thenReturn(
                new Person("nombre",
                        "apellido", LocalDate.of(2000, 1, 1),
                        "123456789", 170, 80)
        );

        Person personResult = useCase.personByDocument("123456789");

        Assertions.assertNotNull(personResult);
        verify(repo).getPerson("123456789");
    }

    @Test
    void person_by_document_InvalidDocument(){
        when(repo.getPerson(anyString())).thenReturn(null);

        Assertions.assertThrows(ExceptionsPerson.class, () -> useCase.personByDocument("1223456"));

        verify(repo, times(1)).getPerson(anyString());
    }
}
