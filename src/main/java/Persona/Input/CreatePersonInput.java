package Persona.Input;

import java.time.LocalDate;

public interface CreatePersonInput {
    Boolean createPerson(String name, String last_name,
                         LocalDate birthdate, String document,
                         float height, float weight);

}
