package com.academy.sosu.controller;

import com.academy.sosu.exception.DatabaseException;
import com.academy.sosu.model.base.BaseMeta;
import com.academy.sosu.model.base.ResponseObject;
import com.academy.sosu.model.dto.common.EmptyDTO;
import com.academy.sosu.model.dto.common.SearchDTO;
import com.academy.sosu.model.dto.student.*;
import com.academy.sosu.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/api/v1/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping
    public @ResponseBody
    ResponseObject<StudentNoDTO> createStudent(@RequestBody StudentCreateDTO requestDTO) {

        //TODO 유효성 검사 로직 추가

        try {
            StudentNoDTO responseDTO = studentService.createStudent(requestDTO);

            return new ResponseObject<>(responseDTO);
        } catch (DatabaseException e) {
            return new ResponseObject<>(e.getMessage());
        }
    }

    @GetMapping
    public @ResponseBody
    ResponseObject<StudentDTO> selectOneStudentByNo(StudentNoDTO requestDTO) {
        try {
            StudentDTO responseDTO = studentService.selectOneStudentByNo(requestDTO);

            return new ResponseObject<>(responseDTO);
        } catch (DatabaseException e) {
            return new ResponseObject<>(e.getMessage());
        }
    }

    //TODO 검색 키워드 확인
    @GetMapping("/{studentNo}")
    public @ResponseBody
    ResponseObject<StudentListDTO> searchStudentList(SearchDTO searchDTO) {

        StudentListDTO studentListDTO = studentService.searchStudentList(searchDTO);
        BaseMeta baseMeta = BaseMeta.builder()
                .searchDTO(searchDTO)
                .totalNum(studentService.selectStudentCount())
                .build();

        return new ResponseObject<>(studentListDTO, baseMeta);
    }

    @PutMapping
    public @ResponseBody
    ResponseObject<StudentDTO> updateStudent(StudentDTO requestDTO) {
        try {
            StudentDTO responseDTO = studentService.updateStudent(requestDTO);

            return new ResponseObject<>(responseDTO);
        } catch (DatabaseException e) {
            return new ResponseObject<>(e.getMessage());
        }
    }

    @DeleteMapping
    public @ResponseBody
    ResponseObject<EmptyDTO> deleteStudent(StudentNoDTO requestDTO) {
        try {
            return new ResponseObject<>(studentService.deleteStudent(requestDTO));
        } catch (DatabaseException e) {
            return new ResponseObject<>(e.getMessage());
        }
    }
}