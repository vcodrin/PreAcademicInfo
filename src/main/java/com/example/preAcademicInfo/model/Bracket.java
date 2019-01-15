package com.example.preAcademicInfo.model;

import com.example.preAcademicInfo.bases.BaseObject;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Bracket extends BaseObject implements Serializable {

    @Column
    private String number;

    @Column
    private String year;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "bracket")
    private Specialization specialization;

    @ManyToMany(mappedBy = "brackets")
    private List<Professor> professors;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bracket", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Student> students;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idGroup", nullable = false)
    private Exam exam;

    public Bracket(String number, String year) {
        this.number = number;
        this.year = year;
    }

}
