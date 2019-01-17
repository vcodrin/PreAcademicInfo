package com.example.preAcademicInfo.model.laboratory;

import com.example.preAcademicInfo.bases.Record;

import javax.persistence.*;
import java.util.List;

@Entity
public class LaboratoryRecord extends Record {

    @Column
    private Float percentageLaboratoryGrade;


    @OneToMany(mappedBy = "laboratoryRecord", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<LaboratoryRecordStudent> records;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLaboratory", nullable = false)
    private Laboratory laboratory;

    public LaboratoryRecord() {
    }

    public String toString(){
        return "s";
    }

    public Float getPercentageLaboratoryGrade() {
        return percentageLaboratoryGrade;
    }

    public void setPercentageLaboratoryGrade(Float percentageLaboratoryGrade) {
        this.percentageLaboratoryGrade = percentageLaboratoryGrade;
    }

    public List<LaboratoryRecordStudent> getRecords() {
        return records;
    }

    public void setRecords(List<LaboratoryRecordStudent> records) {
        this.records = records;
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }
}
