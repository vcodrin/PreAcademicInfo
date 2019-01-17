package com.example.preAcademicInfo.constants;

import com.example.preAcademicInfo.bases.AbstractConstant;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FucntionsC extends AbstractConstant {
    public static FucntionsC ADD_COURSE = new FucntionsC("Add Course", Profile.ADMIN, "/addCourse");
    public static FucntionsC VIEW_COURSES = new FucntionsC("View Course", Profile.STUDENT, "/myCourses");
    public static FucntionsC ADD_STUDENT = new FucntionsC("Add Student", Profile.ADMIN, "/addStudent");
    private Profile profile;
    private String path;

    public static List<FucntionsC> values = Arrays.asList(ADD_COURSE, VIEW_COURSES, ADD_STUDENT);

    public FucntionsC(String name) {
        super(name);
    }
    private FucntionsC(String name, Profile profile, String path) {
        super(name);
        this.profile = profile;
        this.path = path;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FucntionsC that = (FucntionsC) o;
        return Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), path);
    }
}
