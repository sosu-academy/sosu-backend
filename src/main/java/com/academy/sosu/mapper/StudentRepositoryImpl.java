package com.academy.sosu.mapper;

import com.academy.sosu.model.dto.common.SearchRepoDTO;
import com.academy.sosu.model.dto.student.StudentDTO;
import com.academy.sosu.model.dto.student.StudentCreateRequestDTO;
import com.academy.sosu.model.dto.student.StudentNoDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    private String ns = "studentMapper.";

    @Override
    public int insertStudent(StudentCreateRequestDTO requestDTO) {
        return sqlSessionTemplate.insert("insertStudent", requestDTO);
    }

    @Override
    public StudentNoDTO searchStudentId(StudentCreateRequestDTO requestDTO) {
        return sqlSessionTemplate.selectOne("selectStudentId", requestDTO);
    }

    @Override
    public StudentDTO selectOneStudentByNo(StudentNoDTO requestDTO) {
        return sqlSessionTemplate.selectOne("selectOneStudentByNo", requestDTO);
    }

    @Override
    public int selectStudentCount() {
        return sqlSessionTemplate.selectOne("selectStudentCount");
    }

    @Override
    public List<StudentDTO> searchStudentList(SearchRepoDTO repoDTO) {
        return sqlSessionTemplate.selectList("searchStudentList", repoDTO);
    }

    /*
    [ORALCE]
    SELECT * FROM [TABLE] WHERE ROWNUM <= 10

    [MSSQL]
    SELECT TOP 10 * FROM [TABLE]

    [MYSQL]
    SELECT * FROM [TABLE] LIMIT 0,10
     */
}
