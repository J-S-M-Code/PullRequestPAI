package Persona.UseCase;

import Persona.Exceptions.ExceptionsPerson;
import Persona.Exceptions.ExceptionsRepo;
import Persona.Input.CreatePersonInput;
import Persona.Output.SavePersonRepo;
import Persona.model.Person;

import java.time.LocalDate;

public class CreatePersonUseCase implements CreatePersonInput {
    private SavePersonRepo savePersonRepo;
    public CreatePersonUseCase(SavePersonRepo repo){
        savePersonRepo = repo;
    }
    @Override
    public Boolean createPerson(String name, String last_name,
                                LocalDate birthdate, String document,
                                float height, float weight){
        try{
            Person person = Person.create(name, last_name, birthdate,
                    document, height, weight);

            if (this.savePersonRepo.existPerson(document)){
                throw new ExceptionsPerson("Ya existe la persona");
            }

            if (!this.savePersonRepo.savePerson(person)){
                throw new ExceptionsRepo("Fallo en guardar persona");
            }

            return true;
        }catch (ExceptionsPerson e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
