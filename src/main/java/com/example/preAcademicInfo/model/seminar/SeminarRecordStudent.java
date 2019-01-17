package com.example.preAcademicInfo.model.seminar;

import com.example.preAcademicInfo.model.Student;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class SeminarRecordStudent implements Serializable {

    @EmbeddedId
    private SeminarRecordStudentKey id;

    @Column
    private Float extraPoints;

    @Column
    @NotNull
    private Boolean wasPresent;

    @MapsId("seminarRecordId")
    @ManyToOne
    @JoinColumn(name = "seminarRecordId", nullable = false)
    private SeminarRecord seminarRecord;

    @ManyToOne
    @MapsId("studId")
    @JoinColumn(name = "studentId", nullable = false)
    private Student student;

    public SeminarRecordStudent() {
    }

    public SeminarRecordStudentKey getId() {
        return id;
    }

    public void setId(SeminarRecordStudentKey id) {
        this.id = id;
    }

    public Float getExtraPoints() {
        return extraPoints;
    }

    public void setExtraPoints(Float extraPoints) {
        this.extraPoints = extraPoints;
    }

    public Boolean getWasPresent() {
        return wasPresent;
    }

    public void setWasPresent(Boolean wasPresent) {
        this.wasPresent = wasPresent;
    }

    public SeminarRecord getSeminarRecord() {
        return seminarRecord;
    }

    public void setSeminarRecord(SeminarRecord seminarRecord) {
        this.seminarRecord = seminarRecord;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
