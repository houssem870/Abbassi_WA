package com.group.Abbassi_WA.controllers;

/**
 * The {@code PersonController} class is a Spring REST controller that handles API requests related to {@link Person} entities.
 *
 * <p>The controller provides two endpoints: one for creating a new person and another for retrieving all persons.</p>
 *
 * <p>By using the {@code @RestController} and {@code @RequestMapping} annotations, this class defines the base URL
 * '/api' for its endpoints. The {@code @CrossOrigin} annotation is used to enable cross-origin requests from any origin,
 * allowing clients from different domains to access the API.</p>
 *
 * <p>The controller uses the {@link PersonneService} to handle the business logic for creating and retrieving persons.
 * The service class is autowired for dependency injection.</p>
 *
 * @see com.group.Abbassi_WA.DTO.PersonneDTO
 * @see com.group.Abbassi_WA.entities.Person
 * @see com.group.Abbassi_WA.services.PersonService
 * @see org.springframework.web.bind.annotation.RestController
 * @see org.springframework.web.bind.annotation.RequestMapping
 * @see org.springframework.web.bind.annotation.CrossOrigin
 * @since 1.0
 */

import com.group.Abbassi_WA.DTO.PersonDTO;
import com.group.Abbassi_WA.entities.Person;
import com.group.Abbassi_WA.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class PersonController {

    /**
     * The {@code PersonneService} to handle the business logic for persons.
     */
    @Autowired
    PersonService personneService;

    /**
     * API endpoint for creating a new person.
     *
     * @param person The {@link Person} object containing the information of the person to be created.
     * @return A {@link ResponseEntity} with the result of the person creation. The response may contain an HTTP status
     *         indicating the success or failure of the request, as well as additional information in the body.
     */
    @PostMapping("/personnes")
    public ResponseEntity<?> createPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personneService.createPerson(person), HttpStatus.ACCEPTED);
    }

    /**
     * API endpoint for retrieving all persons.
     *
     * @return A {@link ResponseEntity} containing a list of {@link PersonDTO} objects representing all persons.
     *         The response may include an HTTP status indicating the success of the request (200 OK) and the list
     *         of persons in the response body.
     */
    @GetMapping("/personnes")
    public ResponseEntity<List<PersonDTO>> getAllPersons() {
        List<PersonDTO> personnes = personneService.getAllPersons();
        return ResponseEntity.ok(personnes);
    }
}

