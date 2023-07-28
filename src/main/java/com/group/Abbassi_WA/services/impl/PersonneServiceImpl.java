package com.group.Abbassi_WA.services.impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.group.Abbassi_WA.DTO.PersonDTO;
import com.group.Abbassi_WA.Util.PersonneRegistrationException;
import com.group.Abbassi_WA.entities.Person;
import com.group.Abbassi_WA.repositories.PersonneRepository;
import com.group.Abbassi_WA.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonneServiceImpl implements PersonService {

    @Autowired
    private PersonneRepository personneRepository;

    /**
     * Creates a new person and saves it to the database.
     * Throws an exception if the person's age is more than 150 years old.
     *
     * @param person The Person object to be created and saved.
     * @return The saved Person object.
     * @throws PersonneRegistrationException if the person's age is more than 150 years old.
     */
    @Override
    public Person createPerson(Person person) {
        // Calculate the maximum allowed date for a person's birthdate (150 years ago from now).
        LocalDate currentDate = LocalDate.now();
        LocalDate maxAllowedDate = currentDate.minusYears(150);

        // Check if the person's date of birth is after the maximum allowed date.
        if (person.getBirthDate().isAfter(maxAllowedDate)) {
            throw new PersonneRegistrationException("Only persons under 150 years old can be registered");
        }

        // Save the person to the database using the PersonneRepository.
        return personneRepository.save(person);
    }

    /**
     * Retrieves a list of all persons from the database and maps them to PersonDTO objects.
     * Sorts the resulting list based on the first name of each person.
     *
     * @return A sorted list of PersonDTO objects.
     */
    @Override
    public List<PersonDTO> getAllPersons() {
        // Retrieve all persons from the database using the PersonneRepository.
        List<Person> people = personneRepository.findAll();

        // Map each Person object to a PersonDTO object using the mapPersonToDTO method,
        // and sort the resulting list based on the first name of each person.
        return people.stream()
                .map(this::mapPersonToDTO)
                .sorted(Comparator.comparing(PersonDTO::getFirstName))
                .collect(Collectors.toList());
    }

    /**
     * Maps a Person object to a PersonDTO object, calculating the person's age in years.
     *
     * @param person The Person object to be mapped to a PersonDTO object.
     * @return The mapped PersonDTO object.
     */
    private PersonDTO mapPersonToDTO(Person person) {
        // Get the current date.
        LocalDate currentDate = LocalDate.now();

        // Convert the person's date of birth (Date object) to LocalDate.
        LocalDate birthdate = person.getBirthDate();

        // Calculate the person's age based on the birthdate and current date.
        int age = Period.between(birthdate, currentDate).getYears();

        // Create a new PersonDTO object with the person's first name, last name, and age.
        return new PersonDTO(person.getFirstName(), person.getLastName(), age);
    }
}
