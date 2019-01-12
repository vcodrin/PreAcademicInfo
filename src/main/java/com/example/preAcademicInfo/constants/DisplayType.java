package com.example.preAcademicInfo.constants;

import com.example.preAcademicInfo.bases.AbstractConstant;

public class DisplayType extends AbstractConstant {
    public static final DisplayType TEXT = new DisplayType("text");
    public static final DisplayType PASSWORD = new DisplayType("password");
    public static final DisplayType CHECKBOX = new DisplayType("checkbox");
    public static final DisplayType BUTTON = new DisplayType("button");
    public static final DisplayType SUBMIT = new DisplayType("submit");
    public static final DisplayType INPUT_TEXT = new DisplayType("text");
    public static DisplayType[] values = {TEXT, PASSWORD, CHECKBOX, BUTTON, SUBMIT};

    public DisplayType(String name) {
        super(name);
    }


}
