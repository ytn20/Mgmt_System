package com.student.api.student.domain;


import com.student.api.student.domain.enumeration.FeatureType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.jetbrains.annotations.NotNull;

public class Student {

    private String student_name;
    private Long student_id;
    private int student_age;
    private String student_url;

    @NotNull
    @Enumerated(EnumType.STRING)
    private FeatureType featureType;

    //name
    public String getStudent_name() {
        return student_name;
    }
    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    //id
    public Long getStudent_id() {
        return student_id;
    }
    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    //age
    public int getStudent_age() {
        return student_age;
    }
    public void setStudent_age(int student_age) {
        this.student_age = student_age;
    }

    //url
    public String getStudent_url() {
        return student_url;
    }
    public void setStudent_url(String student_url) {
        this.student_url = student_url;
    }

    //FeatureType
    public FeatureType getFeatureType() {
        return featureType;
    }
    public void setFeatureType(FeatureType featureType) {
        this.featureType = featureType;
    }

    @Override
     public String toString() {
        return "Student {" +
                "Student ID=" + student_id +
                ", Student Name='" + student_name + '\'' +
                ", Student Age=" + student_age +
                ", Student Url='" + student_url + '\'' +
                ", Feature Type=" + featureType +
                '}';
     }




}
