package com.academy.sosu.model.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Student {
    public Long studentNo;
    public String studentName;
    public String school;
    public String birthYear;
    public String parentPhoneNo1;
    public String parentPhoneNo2;
    public String studentPhoneNo;
    public String graduateYn;
    public String studentNowYn;

    public enum YNValue {
        Y, N;
    }
}
