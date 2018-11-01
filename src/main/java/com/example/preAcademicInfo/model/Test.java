package com.example.preAcademicInfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Test {

    @Column
    @Id
    private long id;

    public Test() {

    }
}
