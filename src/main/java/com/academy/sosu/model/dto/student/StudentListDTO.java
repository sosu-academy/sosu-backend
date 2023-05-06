package com.academy.sosu.model.dto.student;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class StudentListDTO {
    public List<StudentDTO> students;
}
