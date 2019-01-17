package com.example.preAcademicInfo.model.seminar;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SeminarRecordStudentKey implements Serializable {

    @Column
    private Long seminarRecordId;
    @Column
    private Long studentId;

    public SeminarRecordStudentKey() {
    }

    public Long getSeminarRecordId() {
        return seminarRecordId;
    }

    public void setSeminarRecordId(Long seminarRecordId) {
        this.seminarRecordId = seminarRecordId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
