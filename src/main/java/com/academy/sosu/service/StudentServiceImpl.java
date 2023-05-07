package com.academy.sosu.service;

import com.academy.sosu.exception.ErrorCode;
import com.academy.sosu.exception.DatabaseException;
import com.academy.sosu.mapper.StudentRepository;
import com.academy.sosu.model.dto.common.EmptyDTO;
import com.academy.sosu.model.dto.common.SearchDTO;
import com.academy.sosu.model.dto.common.SearchRepoDTO;
import com.academy.sosu.model.dto.student.StudentDTO;
import com.academy.sosu.model.dto.student.StudentCreateDTO;
import com.academy.sosu.model.dto.student.StudentListDTO;
import com.academy.sosu.model.dto.student.StudentNoDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentNoDTO createStudent(StudentCreateDTO studentCreateDTO) throws DatabaseException {
        int result = studentRepository.insertStudent(studentCreateDTO);

        if (result == 1) {
            return studentRepository.searchStudentId(studentCreateDTO);
        } else {
            throw new DatabaseException(ErrorCode.DB_INSERT_ERROR);
        }
    }

    @Override
    public StudentDTO selectOneStudentByNo(StudentNoDTO studentNoDTO) throws DatabaseException {
        Optional<StudentDTO> studentDTO = Optional.ofNullable(studentRepository.selectOneStudentByNo(studentNoDTO));

        if (studentDTO.isPresent()) {
            return studentDTO.get();
        } else {
            throw new DatabaseException(ErrorCode.DB_SELECT_NO_RESULT);
        }
    }

    @Override
    public StudentListDTO searchStudentList(SearchDTO searchDTO) {
        SearchRepoDTO repoDTO = SearchRepoDTO.builder()
                .searchDTO(searchDTO)
                .build();

        List<StudentDTO> studentDTOS = studentRepository.searchStudentList(repoDTO);

        return StudentListDTO.builder()
                .students(studentDTOS)
                .build();
    }

    @Override
    public int selectStudentCount() {
        return studentRepository.selectStudentCount();
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) throws DatabaseException {
        int updateStudent = studentRepository.updateStudent(studentDTO);
        if (updateStudent == 1) {
            return studentDTO;
        } else {
            throw new DatabaseException(ErrorCode.DB_UPDATE_ERROR);
        }
    }

    @Override
    public EmptyDTO deleteStudent(StudentNoDTO studentNoDTO) throws DatabaseException{
        int deleteStudent = studentRepository.deleteStudent(studentNoDTO);
        if (deleteStudent == 1) {
            return new EmptyDTO();
        } else {
            throw new DatabaseException(ErrorCode.DB_DELETE_ERROR);
        }
    }
}
