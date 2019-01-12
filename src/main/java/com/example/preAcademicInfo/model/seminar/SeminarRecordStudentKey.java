package com.example.preAcademicInfo.model.seminar;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class SeminarRecordStudentKey implements Serializable {

    @Column
    private Long seminarRecordId;
    @Column
    private Long studentId;

}
