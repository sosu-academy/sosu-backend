package com.academy.sosu.service;

import com.academy.sosu.exception.ErrorCode;
import com.academy.sosu.exception.InsertDatabaseException;
import com.academy.sosu.mapper.StudentRepository;
import com.academy.sosu.model.dto.student.StudentCreateRequestDTO;
import com.academy.sosu.model.dto.student.StudentResponseDTO;
import com.academy.sosu.model.object.Student;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentResponseDTO createStudent(StudentCreateRequestDTO requestDTO) throws InsertDatabaseException {
        int result = studentRepository.insertStudent(requestDTO);

        if (result == 1) {
            return studentRepository.searchStudentId(requestDTO);
        } else {
            throw new InsertDatabaseException(ErrorCode.DB_INSERT_ERROR);
        }
    }
}
