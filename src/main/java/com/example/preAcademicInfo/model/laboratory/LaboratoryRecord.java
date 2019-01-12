package com.example.preAcademicInfo.model.laboratory;

import com.example.preAcademicInfo.bases.Record;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class LaboratoryRecord extends Record {

    @Column
    private Float percentageLaboratoryGrade;


    @OneToMany(mappedBy = "laboratoryRecord", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<LaboratoryRecordStudent> records;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLaboratory", nullable = false)
    private Laboratory laboratory;

    public String toString(){
        return "hehe";
    }
}
