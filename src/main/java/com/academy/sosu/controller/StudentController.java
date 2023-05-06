package com.academy.sosu.controller;

import com.academy.sosu.exception.InsertDatabaseException;
import com.academy.sosu.exception.SearchDatabaseException;
import com.academy.sosu.model.base.BaseMeta;
import com.academy.sosu.model.base.ResponseObject;
import com.academy.sosu.model.dto.common.SearchDTO;
import com.academy.sosu.model.dto.student.*;
import com.academy.sosu.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController("/students/api/v1")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public @ResponseBody
    ResponseObject<StudentNoDTO> createStudent(@RequestBody StudentCreateRequestDTO requestDTO) {

        //TODO 유효성 검사 로직 추가

        try {
            StudentNoDTO responseDTO = studentService.createStudent(requestDTO);

            return new ResponseObject<>(responseDTO);
        } catch (InsertDatabaseException e) {
            return new ResponseObject<>(e.getMessage());
        }
    }

    @GetMapping("/search")
    public @ResponseBody
    ResponseObject<StudentDTO> selectOneStudentByNo(StudentNoDTO requestDTO) {
        try {
            StudentDTO responseDTO = studentService.selectOneStudentByNo(requestDTO);

            return new ResponseObject<>(responseDTO);
        } catch (SearchDatabaseException e) {
            return new ResponseObject<>(e.getMessage());
        }
    }

    //TODO 검색 키워드 확인
    @GetMapping("/search")
    public @ResponseBody
    ResponseObject<StudentListDTO> searchStudentList(SearchDTO searchDTO) {

        StudentListDTO studentListDTO = studentService.searchStudentList(searchDTO);
        BaseMeta baseMeta = BaseMeta.builder()
                .searchDTO(searchDTO)
                .totalNum(studentService.selectStudentCount(searchDTO))
                .build();

        return new ResponseObject<>(studentListDTO, baseMeta);
    }

//    @PostMapping("/update")
//
//    @PostMapping("/delete")

}