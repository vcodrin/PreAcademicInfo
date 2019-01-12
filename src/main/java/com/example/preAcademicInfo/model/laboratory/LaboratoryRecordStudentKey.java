package com.example.preAcademicInfo.model.laboratory;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class LaboratoryRecordStudentKey implements Serializable {

    @Column
    private Long labRecordId;
    @Column
    private Long studId;

}
