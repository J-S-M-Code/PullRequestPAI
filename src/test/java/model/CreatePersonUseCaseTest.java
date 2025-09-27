package model;

import Persona.Exceptions.ExceptionsRepo;
import Persona.Output.SavePersonRepo;
import Persona.UseCase.CreatePersonUseCase;
import Persona.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreatePersonUseCaseTest {
    @Mock
    SavePersonRepo repo;
    @InjectMocks
    CreatePersonUseCase useCase;

    @Test
    void createPerson() {
        // Defino el comportamiento del "Emulador" de la db dependiendo de que se le da
        when(repo.existPerson("123456789")).thenReturn(false);
        when(repo.savePerson(any(Person.class))).thenReturn(true);

        Boolean result = useCase.createPerson("nombre",
                "apellido", LocalDate.of(2000, 1, 1),
                "123456789", 170, 80);

        Assertions.assertTrue(result);
        verify(repo).existPerson("123456789");
        verify(repo).savePerson(any(Person.class));
    }

    @Test
    void create_Person_InvalidAtributes() {
        Boolean result = useCase.createPerson("",
                "apellido", LocalDate.of(2000, 1, 1),
                "123456789", 170, 80);

        Assertions.assertFalse(result);
        verify(repo, never()).existPerson(any());
        verify(repo, never()).savePerson(any());
    }

    @Test
    void createPerson_PersonAlreadyExists() {
        when(repo.existPerson("123456789")).thenReturn(true);

        Boolean result = useCase.createPerson("nombre",
                "apellido", LocalDate.of(2000, 1, 1),
                "123456789", 170, 80);

        Assertions.assertFalse(result);

        verify(repo).existPerson("123456789");

        verify(repo, never()).savePerson(any());
    }

    @Test
    void createPerson_SavePersonFails() {
        when(repo.existPerson("123456789")).thenReturn(false);
        when(repo.savePerson(any(Person.class))).thenReturn(false);

        Assertions.assertThrows(ExceptionsRepo.class, () -> {
            useCase.createPerson("nombre",
                    "apellido", LocalDate.of(2000, 1, 1),
                    "123456789", 170, 80);
        });

        verify(repo).existPerson("123456789");
        verify(repo).savePerson(any(Person.class));
    }
}
