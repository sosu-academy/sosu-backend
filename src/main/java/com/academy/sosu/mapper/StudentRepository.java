package com.academy.sosu.mapper;

import com.academy.sosu.model.dto.common.SearchRepoDTO;
import com.academy.sosu.model.dto.student.StudentCreateDTO;
import com.academy.sosu.model.dto.student.StudentDTO;
import com.academy.sosu.model.dto.student.StudentNoDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository {
    int insertStudent(StudentCreateDTO requestDTO);

    StudentNoDTO searchStudentId(StudentCreateDTO requestDTO);

    StudentDTO selectOneStudentByNo(StudentNoDTO requestDTO);

    int selectStudentCount();

    List<StudentDTO> searchStudentList(SearchRepoDTO requestDTO);

    int updateStudent(StudentDTO studentDTO);

    int deleteStudent(StudentNoDTO studentNoDTO);
}
