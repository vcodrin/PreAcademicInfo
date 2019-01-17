package com.example.preAcademicInfo.model.laboratory;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LaboratoryRecordStudentKey implements Serializable {

    @Column
    private Long labRecordId;
    @Column
    private Long studId;

    public LaboratoryRecordStudentKey() {
    }

    public Long getLabRecordId() {
        return labRecordId;
    }

    public void setLabRecordId(Long labRecordId) {
        this.labRecordId = labRecordId;
    }

    public Long getStudId() {
        return studId;
    }

    public void setStudId(Long studId) {
        this.studId = studId;
    }
}
