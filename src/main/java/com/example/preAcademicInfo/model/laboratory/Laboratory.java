package com.example.preAcademicInfo.model.laboratory;


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
public class Laboratory extends AbstractCourseType implements Serializable {


    @OneToMany(mappedBy = "laboratory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LaboratoryRecord> records;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Course course;

    public void setRecords(List<LaboratoryRecord> records) {
        this.records = records;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
