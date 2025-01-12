package com.code2ever.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Objects;


/**
 * Entity class for Person.
 * A standard JPA implementation without Panache. Includes basic fields
 * and a generated ID field of type Long.
 */
@Getter
@Setter
@ToString(callSuper = true)
@Entity
public class Person extends AbstractEntity {

    @NotBlank(message = "First name is required")
    @Size(min = 3, max = 50, message = "First name must be between 3 and 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 3, max = 50, message = "First name must be between 3 and 50 characters")
    private String lastName;

    @Email
    @NotBlank(message = "Email is required")
    private String email;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName, email);
    }
}