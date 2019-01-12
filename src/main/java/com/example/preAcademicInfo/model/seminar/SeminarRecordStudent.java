package com.example.preAcademicInfo.model.seminar;

import com.example.preAcademicInfo.model.Student;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
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

}
