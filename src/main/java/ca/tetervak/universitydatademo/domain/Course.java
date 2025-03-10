package ca.tetervak.universitydatademo.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JPA Entity for a Course offered at the University.
 * <p>
 * Created by maryellenbowman.
 */
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;

    @Column(name="NAME")
    private String name;

    @Column(name="CREDITS")
    private Integer credits;


    @OneToOne
    private Staff instructor;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Course> prerequisites = new ArrayList<>();

    @ManyToOne
    private Department department;

    public Course(String name, Integer credits, Staff instructor, Department department) {
        this.name = name;
        this.credits = credits;
        this.instructor = instructor;
        this.department = department;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    protected Course() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Staff getInstructor() {
        return instructor;
    }
    public void setInstructor(Staff instructor) {
        this.instructor = instructor;
    }

    public Department getDepartment() {
        return department;
    }

    public Course addPrerequisite(Course prerequisite) {
        prerequisites.add(prerequisite);
        return this;
    }


    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", credits=" + credits +
                ", instructor=" + instructor +
                ", department=" + department.getName() +
                '}';
    }
}
