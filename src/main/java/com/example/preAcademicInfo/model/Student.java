package com.example.preAcademicInfo.model;

import com.example.preAcademicInfo.bases.BaseObject;
import com.example.preAcademicInfo.model.laboratory.LaboratoryRecordStudent;
import com.example.preAcademicInfo.model.lecture.LectureRecordStudent;
import com.example.preAcademicInfo.model.seminar.SeminarRecordStudent;
import com.example.preAcademicInfo.validation.userValidation.ValidEmail;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Student extends BaseObject implements Serializable {

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    @Size(min = 13, max = 13)
    private String cnp;

    @Column
    private Boolean tax;

    @Column
    private Boolean budget;

    @Column
    private String nrMatricol;

    @Column(length = 40, nullable = false)
    @Email
    @ValidEmail
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idBracket", nullable = false)
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
}
