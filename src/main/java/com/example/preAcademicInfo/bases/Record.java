package com.example.preAcademicInfo.bases;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class Record extends BaseObject {


    @Column
    @Temporal(value = TemporalType.DATE)
    private Date attendanceDate;

    @Column
    private Boolean requiresGrade;


}
