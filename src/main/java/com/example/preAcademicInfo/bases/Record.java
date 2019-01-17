package com.example.preAcademicInfo.bases;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MappedSuperclass
public abstract class Record extends BaseObject {


    @Column
    @Temporal(value = TemporalType.DATE)
    private Date attendanceDate;

    @Column
    private Boolean requiresGrade;


    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public Boolean getRequiresGrade() {
        return requiresGrade;
    }

    public void setRequiresGrade(Boolean requiresGrade) {
        this.requiresGrade = requiresGrade;
    }
}
