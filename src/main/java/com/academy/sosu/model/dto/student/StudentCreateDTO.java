package com.academy.sosu.model.dto.student;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class StudentCreateDTO {
    public String studentName;
    public String school;
    public String birthYear;
    public String parentPhoneNo1;
    public String parentPhoneNo2;
    public String studentPhoneNo;

//    public Student dtoToModel() {
//        return Student.builder()
//                .studentName(this.studentName)
//                .school(this.school)
//                .birthYear(this.birthYear)
//                .parentPhoneNo1(this.parentPhoneNo1)
//                .parentPhoneNo2(this.parentPhoneNo2)    //nullable
//                .studentPhoneNo(this.studentPhoneNo)    //nullable
//                .build();
//    }
}
