package com.example.preAcademicInfo.model.lecture;

import com.example.preAcademicInfo.bases.AbstractCourseType;
import com.example.preAcademicInfo.bases.Record;
import com.example.preAcademicInfo.model.Course;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Lecture extends AbstractCourseType implements Serializable {

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LectureRecord> records;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Course course;

    public void setRecords(List<LectureRecord> records) {
        this.records = records;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return minAttendances + " " + totalAttendances + " " + finalGradePercentage + " " + requiresGrades;
    }
}
