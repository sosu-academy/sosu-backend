package com.academy.sosu.mapper;

import com.academy.sosu.model.dto.student.StudentCreateRequestDTO;
import com.academy.sosu.model.dto.student.StudentResponseDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository {
    int insertStudent(StudentCreateRequestDTO requestDTO);

    StudentResponseDTO searchStudentId(StudentCreateRequestDTO requestDTO);
}
