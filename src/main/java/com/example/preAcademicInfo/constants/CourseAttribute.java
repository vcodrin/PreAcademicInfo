package com.example.preAcademicInfo.constants;

import com.example.preAcademicInfo.bases.AbstractConstant;

public class CourseAttribute extends AbstractConstant {
    public static final CourseAttribute NAME = new CourseAttribute("name", DisplayType.INPUT_TEXT, true);
    public static final CourseAttribute CODE = new CourseAttribute("code", DisplayType.INPUT_TEXT, true);
    public static final CourseAttribute LECTURE = new CourseAttribute("lecture", DisplayType.INPUT_NUMBER, false, 7, 14);
    public static final CourseAttribute SEMINAR = new CourseAttribute("seminar", DisplayType.INPUT_NUMBER, false, 7, 14);
    public static final CourseAttribute LABORATORY = new CourseAttribute("laboratory", DisplayType.INPUT_NUMBER, false, 7, 14);
    public static final CourseAttribute MIN_ATTENDANCES = new CourseAttribute("minAttendances", DisplayType.INPUT_NUMBER, false, 0, 14);
    public static final CourseAttribute TOTAL_ATTENDANCES = new CourseAttribute("totalAttendances", DisplayType.INPUT_NUMBER, false, 0, 14);
    public static final CourseAttribute FINAL_GRADE_PERCENTAGE = new CourseAttribute("finalGradePercentage", DisplayType.INPUT_NUMBER,false, 0, 100);
    public static final CourseAttribute REQUIRES_GRADES = new CourseAttribute("requiresGrades", DisplayType.CHECKBOX);
    public static CourseAttribute[] values = {
            NAME, CODE, LECTURE, SEMINAR, LABORATORY
    };

    public static CourseAttribute[] common = {
            MIN_ATTENDANCES, TOTAL_ATTENDANCES, FINAL_GRADE_PERCENTAGE, REQUIRES_GRADES
    };
    private DisplayType displayType;
    private Boolean path;

    private CourseAttribute(String name) {
        super(name);
    }

    private CourseAttribute(String name, DisplayType displayType) {
        this(name);
        this.displayType = displayType;
        path = false;
    }

    public CourseAttribute(String code, DisplayType displayType, boolean b) {
        this(code, displayType);
        this.path = b;
    }

    public CourseAttribute(String code, DisplayType displayType, boolean b, int min, int max) {
        this(code, displayType, b);
        this.min = min;
        this.max = max;
    }

    private Integer min;
    private Integer max;

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public DisplayType getDisplayType() {
        return displayType;
    }

    public void setDisplayType(DisplayType displayType) {
        this.displayType = displayType;
    }

    public Boolean isPath() {
        return path;
    }

    public void setPath(Boolean linked) {
        this.path = linked;
    }

}
