package com.example.preAcademicInfo.model;

import com.example.preAcademicInfo.bases.BaseObject;
import com.example.preAcademicInfo.validation.userValidation.ValidEmail;
import com.example.preAcademicInfo.validation.userValidation.ValidPassword;
import com.example.preAcademicInfo.validation.userValidation.ValidUsername;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class User extends BaseObject implements Serializable {

    @Column(nullable = false)
    @Size(min = 5, max = 40, message = "Username must be between {min} and {max} characters")
//    @ValidUsername
    private String username;

    @Column(nullable = false)
//    @ValidPassword
    private String password;

    @Column(length = 40, nullable = false)
    @Email
//    @ValidEmail
    private String email;

    @Column(nullable = false)
    private String profile;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Student student;

    @Column
    private Boolean disabled;


    public User(String username, String password, String email, String profile) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.profile = profile;
    }

    public User(){

    }
}
