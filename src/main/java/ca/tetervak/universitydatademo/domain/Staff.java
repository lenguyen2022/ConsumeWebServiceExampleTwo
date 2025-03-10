package ca.tetervak.universitydatademo.domain;

import jakarta.persistence.*;

/**
 * JPA Entity representing a staff member of a department.
 *
 * Created by maryellenbowman
 */
@Entity
@Table(name="staff_member")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private Person member;

    public Staff(Person member) {
        this.member = member;
    }

    protected Staff() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMember(Person member) {
        this.member = member;
    }

    public Person getMember() {
        return member;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", member=" + member +
                '}';
    }
}
