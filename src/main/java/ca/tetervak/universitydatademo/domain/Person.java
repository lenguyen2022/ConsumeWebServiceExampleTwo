package ca.tetervak.universitydatademo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Person encapsulates an individual's first and last name.
 * <p>
 * Created by maryellenbowman
 */
@Embeddable
public class Person implements Serializable {
    @Column
    private String firstName;

    @Column
    private String lastName;
    public Person() {

    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return  " firstName='" + firstName + '\'' +
                ", lastName='" + lastName + "\' ";
    }
}
