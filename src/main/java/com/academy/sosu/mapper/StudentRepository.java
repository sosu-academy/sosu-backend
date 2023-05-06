package com.academy.sosu.mapper;

import com.academy.sosu.model.dto.common.SearchDTO;
import com.academy.sosu.model.dto.common.SearchRepoDTO;
import com.academy.sosu.model.dto.student.StudentCreateRequestDTO;
import com.academy.sosu.model.dto.student.StudentDTO;
import com.academy.sosu.model.dto.student.StudentNoDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository {
    int insertStudent(StudentCreateRequestDTO requestDTO);

    StudentNoDTO searchStudentId(StudentCreateRequestDTO requestDTO);

    StudentDTO selectOneStudentByNo(StudentNoDTO requestDTO);

    int selectStudentCount();

    List<StudentDTO> searchStudentList(SearchRepoDTO requestDTO);
}
