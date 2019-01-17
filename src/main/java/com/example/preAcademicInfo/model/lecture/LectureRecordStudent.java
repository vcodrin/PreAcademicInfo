package com.example.preAcademicInfo.model.lecture;

import com.example.preAcademicInfo.model.Student;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class LectureRecordStudent implements Serializable {

    @EmbeddedId
    private LectureRecordStudentKey id;

    @Column
    private Float extraPoints;

    @Column
    @NotNull
    private Boolean wasPresent;

    @MapsId("lectureRecordId")
    @ManyToOne
    @JoinColumn(name = "lectureRecordId",nullable = false)
    private LectureRecord lectureRecord;

    @MapsId("studId")
    @ManyToOne
    @JoinColumn(name = "studentId", nullable = false)
    private Student student;

    public LectureRecordStudent() {
    }

    public LectureRecordStudentKey getId() {
        return id;
    }

    public void setId(LectureRecordStudentKey id) {
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

    public LectureRecord getLectureRecord() {
        return lectureRecord;
    }

    public void setLectureRecord(LectureRecord lectureRecord) {
        this.lectureRecord = lectureRecord;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
