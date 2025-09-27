package Persona.model;

import Persona.Exceptions.ExceptionsPerson;

import java.time.LocalDate;
import java.time.Period;

public class Person {

    private String name;
    private String last_name;
    private LocalDate birthdate;
    private String document;
    private float height;
    private float weight;

    public Person(String name, String last_name,
                  LocalDate birthdate, String document,
                  float height, float weight) {
        this.name = name;
        this.last_name = last_name;
        this.birthdate = birthdate;
        this.document = document;
        this.height = height;
        this.weight = weight;
    }

    public static Person create(String name, String last_name,
                                LocalDate birthdate, String document,
                                float height, float weight) {
        if ((name == null) || (name.isBlank())){
            throw new ExceptionsPerson("Nombre nulo o invalido");
        }
        if ((last_name == null) || (last_name.isBlank())) {
            throw new ExceptionsPerson("Apellido nulo o invalido");
        }
        if ((document == null) || (document.isBlank())){
            throw new ExceptionsPerson("Documento nulo o invalido");
        }
        if (height <= 0){
            throw new ExceptionsPerson("La altura debe ser mayor a cero");
        }
        if (weight <= 0){
            throw new ExceptionsPerson("El peso debe ser mayor a cero");
        }
        return new Person(name, last_name, birthdate,
                document, height, weight);
    }

    public String getLast_name() {
        return this.last_name;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public float getHeight() {
        return height;
    }

    public String getDocument() {
        return document;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public int getAge() {
        Period period = Period.between(this.birthdate, LocalDate.now());
        return period.getYears();
    }

    public boolean getIsAdult() {
        int age = getAge();
        return age > 18;

    }

    public String formatDocuement(String document){
        return  this.document.replace(".", "");
    }

}