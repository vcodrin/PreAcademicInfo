package com.example.preAcademicInfo.model;

import com.example.preAcademicInfo.bases.BaseObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Exam extends BaseObject implements Serializable {

    @Column
    private String type;

    @Column
    private Date dueDate;

    @Column
    private Float finalGradePercentage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCourse", nullable = false)
    private Course course;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exam", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Group> groups;

    public Exam(String type, Date dueDate) {
        this.type = type;
        this.dueDate = dueDate;
    }

    public Exam() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Float getFinalGradePercentage() {
        return finalGradePercentage;
    }

    public void setFinalGradePercentage(Float finalGradePercentage) {
        this.finalGradePercentage = finalGradePercentage;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
