package com.academy.sosu.service;

import com.academy.sosu.exception.InsertDatabaseException;
import com.academy.sosu.exception.SearchDatabaseException;
import com.academy.sosu.model.dto.student.StudentDTO;
import com.academy.sosu.model.dto.student.StudentCreateRequestDTO;
import com.academy.sosu.model.dto.student.StudentNoDTO;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    StudentNoDTO createStudent(StudentCreateRequestDTO requestDTO) throws InsertDatabaseException;

    StudentDTO selectOneStudentByNo(StudentNoDTO requestDTO) throws SearchDatabaseException;
}
