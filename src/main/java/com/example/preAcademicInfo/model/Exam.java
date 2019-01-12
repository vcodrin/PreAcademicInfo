package com.example.preAcademicInfo.model;

import com.example.preAcademicInfo.bases.BaseObject;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Exam extends BaseObject implements Serializable {

    @Column
    private String type;

    @Column
    private Date dueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCourse", nullable = false)
    private Course course;

    public Exam(String type, Date dueDate) {
        this.type = type;
        this.dueDate = dueDate;
    }

}
