package com.example.preAcademicInfo.model;

import com.example.preAcademicInfo.bases.BaseObject;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exam", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Bracket> groups;

    public Exam(String type, Date dueDate) {
        this.type = type;
        this.dueDate = dueDate;
    }

}
