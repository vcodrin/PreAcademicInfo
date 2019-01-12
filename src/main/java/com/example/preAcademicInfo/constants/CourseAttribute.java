package com.example.preAcademicInfo.constants;

import com.example.preAcademicInfo.bases.AbstractConstant;

public class CourseAttribute extends AbstractConstant {
    public CourseAttribute(String name) {
        super(name);
    }

    private DisplayType displayType;

    public CourseAttribute(String name, DisplayType displayType) {
        this(name);
        this.displayType = displayType;
    }

    public static final CourseAttribute NAME = new CourseAttribute("name", DisplayType.INPUT_TEXT);
    public static final CourseAttribute CODE = new CourseAttribute("code", DisplayType.INPUT_TEXT);
    public static final CourseAttribute LECTURE = new CourseAttribute("lecture", DisplayType.CHECKBOX);
    public static final CourseAttribute SEMINAR = new CourseAttribute("seminar", DisplayType.CHECKBOX);
    public static final CourseAttribute LABORATORY = new CourseAttribute("laboratory", DisplayType.CHECKBOX);

    public static CourseAttribute[] values = {
            NAME, CODE, LECTURE, SEMINAR, LABORATORY
    };

    public static CourseAttribute[] checkboxes = {LECTURE, SEMINAR, LABORATORY};

    public DisplayType getDisplayType() {
        return displayType;
    }

    public void setDisplayType(DisplayType displayType) {
        this.displayType = displayType;
    }
}
