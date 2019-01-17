package com.example.preAcademicInfo.model;

import com.example.preAcademicInfo.bases.BaseObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
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
    @JoinColumn(name = "idGroup")
    private Exam exam;

    public Bracket(String number, String year) {
        this.number = number;
        this.year = year;
    }

    public Bracket() {

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
}
