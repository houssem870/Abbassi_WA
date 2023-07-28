/**
 * The {@code PersonneDTO} class is a Data Transfer Object (DTO) that represents a simplified version of a person entity.
 *
 * <p>DTOs are used to transfer data between different layers of an application, especially when exposing data through
 * APIs. By using a DTO, we can control the information sent to clients, providing only the necessary data while hiding
 * any sensitive or unnecessary details.</p>
 *
 * <p>The class is annotated with {@code @Data} and {@code @AllArgsConstructor} from the Lombok library, which generates
 * boilerplate code for getters, setters, and constructors based on the class fields.</p>
 *
 * <p>The {@code PersonneDTO} contains two fields: {@code personne_nom} (the name of the person) and {@code age}
 * (the person's age). These fields are used to provide a concise representation of a person's data for API responses.</p>
 *
 * @see lombok.Data
 * @see lombok.AllArgsConstructor
 * @since 1.0
 */
package com.group.Abbassi_WA.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class PersonDTO {
    /**
     * The name of the person.
     */
    private String FirstName;
    /**
     * The LastName of the person.
     */
    private String LastName ;
    /**
     * The age of the person.
     */
    private int age;
}
