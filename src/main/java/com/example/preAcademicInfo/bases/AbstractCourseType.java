package com.example.preAcademicInfo.bases;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class AbstractCourseType extends BaseObject {

    @Column
    @NotNull
    protected Integer minAttendances;

    @Column
    @NotNull
    protected Integer totalAttendances;

    @Column
    @NotNull
    protected Integer finalGradePercentage;

    @Column
    @NotNull
    protected Boolean requiresGrades;

    @Column
    @NotNull
    protected Boolean requiresPresence;


    public Boolean getRequiresGrades() {
        return requiresGrades;
    }

    public void setRequiresGrades(Boolean requiresGrades) {
        this.requiresGrades = requiresGrades;
    }

    public Boolean getRequiresPresence() {
        return requiresPresence;
    }

    public void setRequiresPresence(Boolean requiresPresence) {
        this.requiresPresence = requiresPresence;
    }


    public Integer getMinAttendances() {
        return minAttendances;
    }

    public void setMinAttendances(Integer minAttendances) {
        this.minAttendances = minAttendances;
    }

    public Integer getTotalAttendances() {
        return totalAttendances;
    }

    public void setTotalAttendances(Integer totalAttendances) {
        this.totalAttendances = totalAttendances;
    }

    public void setFinalGradePercentage(Integer finalGradePercentage) {
        this.finalGradePercentage = finalGradePercentage;
    }

    public Integer getFinalGradePercentage() {
        return finalGradePercentage;
    }

}
