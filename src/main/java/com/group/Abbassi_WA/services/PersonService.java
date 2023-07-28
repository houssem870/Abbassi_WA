package com.group.Abbassi_WA.services;

import com.group.Abbassi_WA.DTO.PersonDTO;
import com.group.Abbassi_WA.entities.Person;

import java.util.List;

public interface PersonService {
    /**
     * Retrieves a list of all persons in the application.
     *
     * @return A list of PersonDTO objects representing all persons in the application.
     */
    List<PersonDTO> getAllPersons();

    /**
     * Creates a new person and saves it to the data storage.
     *
     * @param person The Person object representing the new person to be created.
     * @return The newly created Person object.
     */
    Person createPerson(Person person);
}
