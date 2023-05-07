package com.academy.sosu.service;

import com.academy.sosu.exception.DatabaseException;
import com.academy.sosu.model.dto.common.EmptyDTO;
import com.academy.sosu.model.dto.common.SearchDTO;
import com.academy.sosu.model.dto.student.StudentDTO;
import com.academy.sosu.model.dto.student.StudentCreateDTO;
import com.academy.sosu.model.dto.student.StudentListDTO;
import com.academy.sosu.model.dto.student.StudentNoDTO;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    StudentNoDTO createStudent(StudentCreateDTO requestDTO) throws DatabaseException;

    StudentDTO selectOneStudentByNo(StudentNoDTO requestDTO) throws DatabaseException;

    StudentListDTO searchStudentList(SearchDTO requestDTO);

    int selectStudentCount();

    StudentDTO updateStudent(StudentDTO studentDTO) throws DatabaseException;

    EmptyDTO deleteStudent(StudentNoDTO studentNoDTO) throws DatabaseException;
}
