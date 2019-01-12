package com.example.preAcademicInfo.model;

import com.example.preAcademicInfo.bases.BaseObject;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
@Data
public class Specialization extends BaseObject implements Serializable {

    @Column
    private String name;

    @Column
    private String number;

    @Column
    private String line;

    @OneToOne(fetch = FetchType.LAZY)
    private Bracket bracket;


    public Specialization(String name, String number, String line) {
        this.name = name;
        this.number = number;
        this.line = line;
    }

}
