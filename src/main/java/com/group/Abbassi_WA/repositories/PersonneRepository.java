/**
 * The {@code PersonneRepository} interface is a Spring Data JPA repository that provides access to the {@link Personne} entity.
 *
 * <p>Spring Data JPA provides a convenient way to work with databases by generating the necessary database queries based
 * on method names defined in this interface. The {@code JpaRepository} interface contains methods for common database
 * operations such as saving, deleting, and finding entities.</p>
 *
 * <p>In this case, the {@code PersonneRepository} extends the {@code JpaRepository} with {@link Personne} as the entity
 * class and {@link Integer} as the type of the primary key (ID) for the {@link Personne} entity.</p>
 *
 * <p>By extending {@code JpaRepository}, we can use methods like {@code save}, {@code findById}, {@code findAll},
 * {@code delete}, and many more without the need to write explicit query statements.</p>
 *
 * @see org.springframework.data.jpa.repository.JpaRepository
 * @see com.group.Abbassi_WA.entities.Person
 * @since 1.0
 */

package com.group.Abbassi_WA.repositories;

import com.group.Abbassi_WA.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Person, Integer> {
}
