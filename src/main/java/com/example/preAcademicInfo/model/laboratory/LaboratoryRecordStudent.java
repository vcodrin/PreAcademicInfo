package com.example.preAcademicInfo.model.laboratory;

import com.example.preAcademicInfo.model.Student;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class LaboratoryRecordStudent implements Serializable {

    @EmbeddedId
    private LaboratoryRecordStudentKey id;

    @Column
    private Float grade;

    @Column
    @NotNull
    private Date dateRegistered;

    @Column
    @NotNull
    private Boolean wasPresent;

    @ManyToOne
    @MapsId("labRecordId")
    @JoinColumn(name = "laboratoryRecordId", nullable = false)
    private LaboratoryRecord laboratoryRecord;

    @ManyToOne
    @MapsId("studId")
    @JoinColumn(name = "studentId", nullable = false)
    private Student student;

    public LaboratoryRecordStudent() {
    }

    public LaboratoryRecordStudentKey getId() {
        return id;
    }

    public void setId(LaboratoryRecordStudentKey id) {
        this.id = id;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public Boolean getWasPresent() {
        return wasPresent;
    }

    public void setWasPresent(Boolean wasPresent) {
        this.wasPresent = wasPresent;
    }

    public LaboratoryRecord getLaboratoryRecord() {
        return laboratoryRecord;
    }

    public void setLaboratoryRecord(LaboratoryRecord laboratoryRecord) {
        this.laboratoryRecord = laboratoryRecord;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
