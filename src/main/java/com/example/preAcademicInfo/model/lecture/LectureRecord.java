package com.example.preAcademicInfo.model.lecture;

import com.example.preAcademicInfo.bases.Record;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class LectureRecord extends Record {

    @OneToMany(mappedBy = "lectureRecord", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LectureRecordStudent> records;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLecture", nullable = false)
    private Lecture lecture;

    public LectureRecord() {
    }

    public List<LectureRecordStudent> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<LectureRecordStudent> records) {
        this.records = records;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public void setRecords(List<LectureRecordStudent> records) {
        this.records = records;
    }

    public Lecture getLecture() {
        return lecture;
    }
}
