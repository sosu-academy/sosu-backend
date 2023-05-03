package com.academy.sosu.controller;

import com.academy.sosu.exception.InsertDatabaseException;
import com.academy.sosu.exception.SearchDatabaseException;
import com.academy.sosu.model.base.ResponseObject;
import com.academy.sosu.model.dto.student.StudentDTO;
import com.academy.sosu.model.dto.student.StudentCreateRequestDTO;
import com.academy.sosu.model.dto.student.StudentNoDTO;
import com.academy.sosu.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController("/students")
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

//    @GetMapping("/search")
//    public ResponseObject<Student> searchAllStudent() {
//        return new ResponseObject<Student>();
//    }

//    @PostMapping("/update")
//
//    @PostMapping("/delete")

}