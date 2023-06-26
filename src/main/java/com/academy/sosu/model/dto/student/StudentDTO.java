package com.academy.sosu.model.dto.student;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class StudentDTO {

//    public Long studentNo;

    @NotBlank(message = "Name is mandatory")
    public String studentName;

    @NotBlank(message = "School is mandatory")
    public String school;

    @NotBlank(message = "Birth Year is mandatory")
    public String birthYear;

    @NotBlank(message = "Parent Phone Number is mandatory")
    public String parentPhoneNo1;

    public String parentPhoneNo2;

    public String studentPhoneNo;

    public YNValue graduateYn;

    public YNValue studentNowYn;

    public enum YNValue {
        Y, N;
    }

    @Builder
    public StudentDTO(Long studentNo, String studentName, String school, String birthYear, String parentPhoneNo1, String parentPhoneNo2, String studentPhoneNo, YNValue graduateYn, YNValue studentNowYn) {
//        this.studentNo = studentNo;
        this.studentName = studentName;
        this.school = school;
        this.birthYear = birthYear;
        this.parentPhoneNo1 = parentPhoneNo1;
        this.parentPhoneNo2 = parentPhoneNo2;
        this.studentPhoneNo = studentPhoneNo;
        this.graduateYn = graduateYn;
        this.studentNowYn = studentNowYn;
    }
}
