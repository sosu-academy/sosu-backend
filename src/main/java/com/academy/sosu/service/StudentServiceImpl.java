package com.academy.sosu.service;

import com.academy.sosu.exception.ErrorCode;
import com.academy.sosu.exception.InsertDatabaseException;
import com.academy.sosu.exception.SearchDatabaseException;
import com.academy.sosu.mapper.StudentRepository;
import com.academy.sosu.model.dto.student.StudentDTO;
import com.academy.sosu.model.dto.student.StudentCreateRequestDTO;
import com.academy.sosu.model.dto.student.StudentNoDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentNoDTO createStudent(StudentCreateRequestDTO requestDTO) throws InsertDatabaseException {
        int result = studentRepository.insertStudent(requestDTO);

        if (result == 1) {
            return studentRepository.searchStudentId(requestDTO);
        } else {
            throw new InsertDatabaseException(ErrorCode.DB_INSERT_ERROR);
        }
    }

    @Override
    public StudentDTO selectOneStudentByNo(StudentNoDTO requestDTO) throws SearchDatabaseException {
        Optional<StudentDTO> studentDTO = Optional.ofNullable(studentRepository.selectOneStudentByNo(requestDTO));

        if (studentDTO.isPresent()) {
            return studentDTO.get();
        } else {
            throw new SearchDatabaseException(ErrorCode.DB_SELECT_NO_RESULT);
        }
    }
}
