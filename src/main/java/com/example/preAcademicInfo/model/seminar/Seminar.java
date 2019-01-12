package com.example.preAcademicInfo.model.seminar;

import com.example.preAcademicInfo.bases.AbstractCourseType;
import com.example.preAcademicInfo.model.Course;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Seminar extends AbstractCourseType implements Serializable {

    @OneToMany(mappedBy = "seminar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeminarRecord> records;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Course course;

    public void setRecords(List<SeminarRecord> records) {
        this.records = records;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
