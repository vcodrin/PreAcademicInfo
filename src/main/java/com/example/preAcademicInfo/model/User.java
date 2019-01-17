package com.example.preAcademicInfo.model;

import com.example.preAcademicInfo.bases.BaseObject;
import com.example.preAcademicInfo.validation.userValidation.ValidPassword;
import com.example.preAcademicInfo.validation.userValidation.ValidUsername;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class User extends BaseObject implements Serializable {

    @Column(nullable = false)
    @Size(min = 5, max = 40, message = "Username must be between {min} and {max} characters")
//    @ValidUsername
    private String username;

    @Column(nullable = false)
    @ValidPassword
    private String password;

    @Column(length = 40, nullable = false)
    @Email
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }
}
