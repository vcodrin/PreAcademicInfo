package com.example.preAcademicInfo.model;

import com.example.preAcademicInfo.bases.BaseObject;
import com.example.preAcademicInfo.utils.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class Specialization extends BaseObject implements Serializable {

    @Column
    @Type(inputType = "text", path = "name")
    private String name;

    @Column
    @Type(inputType = "number", path = "number")
    private String number;

    @Column
    @Type(inputType = "text", path = "line")
    private String line;

    @OneToOne(fetch = FetchType.LAZY)
    private Group group;


    public Specialization(String name, String number, String line) {
        this.name = name;
        this.number = number;
        this.line = line;
    }

    public Specialization() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
