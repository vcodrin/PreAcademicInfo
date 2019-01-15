package com.example.preAcademicInfo.data;


import com.fasterxml.jackson.dataformat.xml.annotation.*;

import java.util.Objects;

public class Function {

    @JacksonXmlProperty(localName = "id", isAttribute = true)
    private Integer id;
    @JacksonXmlProperty(localName = "name")
    private String name;
    @JacksonXmlProperty(localName = "profile")
    private String profile;
    @JacksonXmlProperty(localName = "url")
    private String url;

    public Function(Integer id, String name, String profile, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.profile = profile;
    }

    public Function() {
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Function{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profile='" + profile + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Function function = (Function) o;
        return Objects.equals(url, function.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }
}
