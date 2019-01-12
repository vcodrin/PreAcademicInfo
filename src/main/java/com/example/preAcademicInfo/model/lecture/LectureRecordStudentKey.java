package com.example.preAcademicInfo.model.lecture;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class LectureRecordStudentKey implements Serializable {

    @Column
    private Long lectureRecordId;
    @Column
    private Long studentId;

}
