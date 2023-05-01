package com.academy.sosu.service;

import com.academy.sosu.model.dto.student.StudentCreateRequestDTO;
import com.academy.sosu.model.dto.student.StudentResponseDTO;
import com.academy.sosu.model.object.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    StudentResponseDTO createStudent(StudentCreateRequestDTO requestDTO);
}
