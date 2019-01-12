package com.example.preAcademicInfo.model;

import com.example.preAcademicInfo.bases.BaseObject;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Professor extends BaseObject implements Serializable {

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String title;

    @ManyToMany
    @JoinTable(
            name = "professorBracket",
            joinColumns = @JoinColumn(name = "idProfessor"),
            inverseJoinColumns = @JoinColumn(name = "idBracket"))
    private List<Bracket> brackets;

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

}
