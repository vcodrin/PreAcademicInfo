package com.example.preAcademicInfo.model.lecture;

import com.example.preAcademicInfo.model.Student;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
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

}
