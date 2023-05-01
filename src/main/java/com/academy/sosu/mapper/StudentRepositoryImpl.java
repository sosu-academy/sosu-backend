package com.academy.sosu.mapper;

import com.academy.sosu.model.dto.student.StudentCreateRequestDTO;
import com.academy.sosu.model.dto.student.StudentResponseDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    private String ns = "studentMapper.";

    @Override
    public int insertStudent(StudentCreateRequestDTO requestDTO) {
        return sqlSessionTemplate.insert("insertStudent", requestDTO);
    }

    @Override
    public StudentResponseDTO searchStudentId(StudentCreateRequestDTO requestDTO) {
        return sqlSessionTemplate.selectOne("selectStudentId", requestDTO);
    }
}