package com.example.preAcademicInfo.constants;

import com.example.preAcademicInfo.bases.AbstractConstant;


public class Profile extends AbstractConstant {


    public static final Profile ADMIN = new Profile("Admin");
    public static final Profile STUDENT = new Profile("Student");
    public static final Profile PROFESSOR = new Profile("Professor");

    public static final Profile[] values = new Profile[]{ADMIN, STUDENT, PROFESSOR};

    private Profile(String name) {
        super(name);
    }


}