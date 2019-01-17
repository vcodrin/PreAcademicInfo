package com.example.preAcademicInfo.model.lecture;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LectureRecordStudentKey implements Serializable {

    @Column
    private Long lectureRecordId;
    @Column
    private Long studentId;

    public LectureRecordStudentKey() {
    }

    public Long getLectureRecordId() {
        return lectureRecordId;
    }

    public void setLectureRecordId(Long lectureRecordId) {
        this.lectureRecordId = lectureRecordId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
