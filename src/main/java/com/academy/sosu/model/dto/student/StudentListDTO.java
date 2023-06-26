package com.academy.sosu.model.dto.student;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@ToString
public class StudentListDTO {
    public List<StudentDTO> students;

    @Builder
    public StudentListDTO(List<StudentDTO> students) {
        this.students = students;
    }
}
