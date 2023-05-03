package com.academy.sosu.model.dto.student;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StudentDTO {
    public Long studentNo;
    public String studentName;
    public String school;
    public String birthYear;
    public String parentPhoneNo1;
    public String parentPhoneNo2;
    public String studentPhoneNo;
    public YNValue graduateYn;
    public YNValue studentNowYn;

    public enum YNValue {
        Y, N;
    }
}
