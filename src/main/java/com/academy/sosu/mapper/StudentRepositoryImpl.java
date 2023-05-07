package com.academy.sosu.mapper;

import com.academy.sosu.model.dto.common.SearchRepoDTO;
import com.academy.sosu.model.dto.student.StudentDTO;
import com.academy.sosu.model.dto.student.StudentCreateDTO;
import com.academy.sosu.model.dto.student.StudentNoDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    private static final String ns = "studentMapper.";

    @Override
    public int insertStudent(StudentCreateDTO studentCreateDTO) {
        return sqlSessionTemplate.insert(ns + "insertStudent", studentCreateDTO);
    }

    @Override
    public StudentNoDTO searchStudentId(StudentCreateDTO studentCreateDTO) {
        return sqlSessionTemplate.selectOne(ns + "selectStudentId", studentCreateDTO);
    }

    @Override
    public StudentDTO selectOneStudentByNo(StudentNoDTO studentNoDTO) {
        return sqlSessionTemplate.selectOne(ns + "selectOneStudentByNo", studentNoDTO);
    }

    @Override
    public int selectStudentCount() {
        return sqlSessionTemplate.selectOne(ns + "selectStudentCount");
    }

    @Override
    public List<StudentDTO> searchStudentList(SearchRepoDTO repoDTO) {
        return sqlSessionTemplate.selectList(ns + "searchStudentList", repoDTO);
    }

    @Override
    public int updateStudent(StudentDTO studentDTO) {
        return sqlSessionTemplate.update(ns + "updateStudent", studentDTO);
    }

    @Override
    public int deleteStudent(StudentNoDTO studentNoDTO) {
        return sqlSessionTemplate.delete(ns + "deleteStudent", studentNoDTO);
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
