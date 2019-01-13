package com.example.preAcademicInfo.dto;

import com.example.preAcademicInfo.model.Course;
import com.example.preAcademicInfo.model.laboratory.Laboratory;
import com.example.preAcademicInfo.model.lecture.Lecture;
import com.example.preAcademicInfo.model.seminar.Seminar;

public class CourseDTO {
    private Course course;
    private Laboratory laboratory;
    private Seminar seminar;
    private Lecture lecture;

    public CourseDTO() {
        course = new Course();
        laboratory = new Laboratory();
        seminar = new Seminar();
        lecture = new Lecture();
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    public Seminar getSeminar() {
        return seminar;
    }

    public void setSeminar(Seminar seminar) {
        this.seminar = seminar;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public String toString() {
        return course.toString() + "\n" + laboratory.toString() + "\n" + seminar.toString() + "\n" + lecture.toString() + "\n";
    }
}
