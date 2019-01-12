package com.example.preAcademicInfo.model.seminar;

import com.example.preAcademicInfo.bases.Record;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class SeminarRecord extends Record {

    @OneToMany(mappedBy = "seminarRecord", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SeminarRecordStudent> records;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSeminar", nullable = false)
    private Seminar seminar;

}
