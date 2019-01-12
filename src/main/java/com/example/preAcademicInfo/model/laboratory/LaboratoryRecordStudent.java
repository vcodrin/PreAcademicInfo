package com.example.preAcademicInfo.model.laboratory;

import com.example.preAcademicInfo.model.Student;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class LaboratoryRecordStudent implements Serializable {

    @EmbeddedId
    private LaboratoryRecordStudentKey id;

    @Column
    private Float grade;

    @Column
    @NotNull
    private Date dateRegistered;

    @Column
    @NotNull
    private Boolean wasPresent;

    @ManyToOne
    @MapsId("labRecordId")
    @JoinColumn(name = "laboratoryRecordId", nullable = false)
    private LaboratoryRecord laboratoryRecord;

    @ManyToOne
    @MapsId("studId")
    @JoinColumn(name = "studentId", nullable = false)
    private Student student;

}
