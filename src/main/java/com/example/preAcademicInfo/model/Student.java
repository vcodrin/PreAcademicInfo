package com.example.preAcademicInfo.model;

import com.example.preAcademicInfo.bases.BaseObject;
import com.example.preAcademicInfo.model.laboratory.LaboratoryRecordStudent;
import com.example.preAcademicInfo.model.lecture.LectureRecordStudent;
import com.example.preAcademicInfo.model.seminar.SeminarRecordStudent;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
public class Student extends BaseObject implements Serializable {

    @Column
    @NotNull
    private String firstName;

    @Column
    @NotNull
    private String lastName;

    @Column
    @Size(min = 13, max = 13, message = "CNP must contain only 13 characters")
    @NotNull
    private String cnp;

    @Column
    private Boolean tax;

    @Column
    private Boolean budget;

    @Column
    @NotNull
    private String nrMatricol;

    @Column(length = 40, nullable = false)
    @Email
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idBracket")
    private Bracket bracket;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses;

    @OneToMany(mappedBy = "laboratoryRecord", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LaboratoryRecordStudent> laboratories;

    @OneToMany(mappedBy = "seminarRecord", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SeminarRecordStudent> seminars;

    @OneToMany(mappedBy = "lectureRecord", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LectureRecordStudent> lectures;



    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "student")
    private User user;

    public Student(String firstName, String lastName, @Size(min = 13, max = 13) String cnp, Boolean tax, Boolean budget) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.tax = tax;
        this.budget = budget;
    }

    public Student(){

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

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public Boolean getTax() {
        return tax;
    }

    public void setTax(Boolean tax) {
        this.tax = tax;
    }

    public Boolean getBudget() {
        return budget;
    }

    public void setBudget(Boolean budget) {
        this.budget = budget;
    }

    public String getNrMatricol() {
        return nrMatricol;
    }

    public void setNrMatricol(String nrMatricol) {
        this.nrMatricol = nrMatricol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Bracket getBracket() {
        return bracket;
    }

    public void setBracket(Bracket bracket) {
        this.bracket = bracket;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<LaboratoryRecordStudent> getLaboratories() {
        return laboratories;
    }

    public void setLaboratories(List<LaboratoryRecordStudent> laboratories) {
        this.laboratories = laboratories;
    }

    public List<SeminarRecordStudent> getSeminars() {
        return seminars;
    }

    public void setSeminars(List<SeminarRecordStudent> seminars) {
        this.seminars = seminars;
    }

    public List<LectureRecordStudent> getLectures() {
        return lectures;
    }

    public void setLectures(List<LectureRecordStudent> lectures) {
        this.lectures = lectures;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
