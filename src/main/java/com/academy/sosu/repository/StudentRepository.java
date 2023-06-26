package com.academy.sosu.repository;

import com.academy.sosu.model.dto.common.SearchRepoDTO;
import com.academy.sosu.model.dto.student.StudentDTO;
import com.academy.sosu.model.dto.student.StudentNoDTO;

import java.util.List;

public interface StudentRepository {
    Long insertStudent(StudentDTO requestDTO);

    StudentDTO selectOneStudentByNo(StudentNoDTO requestDTO);

    int selectStudentCount();

    List<StudentDTO> searchStudentList(SearchRepoDTO requestDTO);

    int updateStudent(StudentDTO studentDTO);

    int deleteStudent(StudentNoDTO studentNoDTO);
}
