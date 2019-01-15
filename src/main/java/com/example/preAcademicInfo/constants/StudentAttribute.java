package com.example.preAcademicInfo.constants;

import com.example.preAcademicInfo.bases.AbstractConstant;

public class StudentAttribute extends AbstractConstant {
    public StudentAttribute(String name) {
        super(name);
    }

    public static StudentAttribute FIRST_NAME = new StudentAttribute("firstName");
    public static StudentAttribute LAST_NAME = new StudentAttribute("lastName");
    public static StudentAttribute CNP = new StudentAttribute("cnp");
    public static StudentAttribute NR_MATRICOL = new StudentAttribute("nrMatricol");
    public static StudentAttribute EMAIL = new StudentAttribute("email");

    public static StudentAttribute[] values = {FIRST_NAME, LAST_NAME, CNP, NR_MATRICOL, EMAIL};



}
