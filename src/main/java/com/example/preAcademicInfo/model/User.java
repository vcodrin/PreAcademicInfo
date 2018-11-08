package com.example.preAcademicInfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id
    @Column
    private long id;

    @Column(length = 40, nullable = false)
    @Size(min=8, max = 40, message = "Username must be between {min} and {max} characters")
    private String username;

    @Column(length = 40, nullable = false)
    private String password;

    @Column(length = 40, nullable = false)
    private String email;

    @Column(nullable = false)
    private Profile profile;

    public User() {
    }

    public User(String username, String password, String email, Profile profile) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.profile = profile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", profile=" + profile +
                '}';
    }
}
