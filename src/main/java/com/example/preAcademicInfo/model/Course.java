package com.example.preAcademicInfo.model;

import com.example.preAcademicInfo.bases.BaseObject;
import com.example.preAcademicInfo.model.laboratory.Laboratory;
import com.example.preAcademicInfo.model.lecture.Lecture;
import com.example.preAcademicInfo.model.seminar.Seminar;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Course extends BaseObject implements Serializable {

    @Column
    private String name;

    @Column
    private String code;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course", orphanRemoval = true)
    private List<Exam> exams;

    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "course")
    private Lecture lecture;

    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "course")
    private Seminar seminar;

    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "course")
    private Laboratory laboratory;

    @ManyToMany
    @JoinTable(
            name = "studentCourse",
            joinColumns = @JoinColumn(name = "idCourse"),
            inverseJoinColumns = @JoinColumn(name = "idStudent"))
    private List<Student> students;

    @ManyToMany(mappedBy = "courses")
    private List<Professor> professors;

    public Course(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Course() {
    }

    public String toString(){
        return name +" "+ code;
    }
}
