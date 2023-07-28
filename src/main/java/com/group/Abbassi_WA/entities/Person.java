
/**
 * The {@code Personne} class represents a person entity with basic information such as ID, first name,
 * last name, and date of birth. Instances of this class are intended to be mapped to a database table
 * using the Jakarta Persistence API (JPA) annotations.
 *
 * <p>The class contains fields to store information about a person and uses appropriate annotations to
 * specify how the data should be persisted in the database.</p>
 *
 * <p>Note: This class uses the Jakarta Persistence API (JPA) annotations for mapping, and it assumes that
 * the appropriate JPA implementation is configured in the application context.</p>
 *
 *
 */
package com.group.Abbassi_WA.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
@Data
@Entity
public class Person {

    /**
     * The unique identifier (ID) for the person.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    /**
     * The first name of the person.
     */
    private String FirstName;

    /**
     * The last name of the person.
     */
    private String LastName;

    /**
     * The date of birth of the person.
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate BirthDate;

}
