package com.example.preAcademicInfo.model.seminar;

import com.example.preAcademicInfo.bases.Record;

import javax.persistence.*;
import java.util.List;

@Entity
public class SeminarRecord extends Record {

    @OneToMany(mappedBy = "seminarRecord", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SeminarRecordStudent> records;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSeminar", nullable = false)
    private Seminar seminar;

    public SeminarRecord() {
    }

    public List<SeminarRecordStudent> getRecords() {
        return records;
    }

    public void setRecords(List<SeminarRecordStudent> records) {
        this.records = records;
    }

    public Seminar getSeminar() {
        return seminar;
    }

    public void setSeminar(Seminar seminar) {
        this.seminar = seminar;
    }
}
