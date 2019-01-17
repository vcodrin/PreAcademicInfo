package com.example.preAcademicInfo.model;

import com.example.preAcademicInfo.bases.BaseObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Professor extends BaseObject implements Serializable {

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String title;

    @ManyToMany
    @JoinTable(
            name = "professorGroup",
            joinColumns = @JoinColumn(name = "idProfessor"),
            inverseJoinColumns = @JoinColumn(name = "idGroup"))
    private List<Group> groups;

    @ManyToMany
    @JoinTable(
            name = "professorCourse",
            joinColumns = @JoinColumn(name = "idProfessor"),
            inverseJoinColumns = @JoinColumn(name = "idCourse"))
    private List<Course> courses;

    public Professor(String firstName, String lastName, String title) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
    }

    public Professor() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
