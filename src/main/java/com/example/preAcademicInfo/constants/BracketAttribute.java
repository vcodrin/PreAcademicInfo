package com.example.preAcademicInfo.constants;

import com.example.preAcademicInfo.bases.AbstractConstant;

public class BracketAttribute extends AbstractConstant {
    public BracketAttribute(String name) {
        super(name);
    }

    public static final BracketAttribute number = new BracketAttribute("number");
    public static final BracketAttribute year = new BracketAttribute("year");


    public static final BracketAttribute[] values = new BracketAttribute[]{number, year};

}
