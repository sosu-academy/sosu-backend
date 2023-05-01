package com.academy.sosu.controller;

import com.academy.sosu.model.base.ResponseObject;
import com.academy.sosu.model.dto.student.StudentCreateRequestDTO;
import com.academy.sosu.model.dto.student.StudentResponseDTO;
import com.academy.sosu.model.object.Student;
import com.academy.sosu.service.StudentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public ResponseObject<StudentResponseDTO> createStudent(StudentCreateRequestDTO requestDTO) {
        StudentResponseDTO responseDTO = studentService.createStudent(requestDTO);
        return new ResponseObject<>(responseDTO);
    }



    //    @GetMapping("/search")
//
//    @PostMapping("/create")
//    public ResponseObject<StudentResponseDTO> createStudent(StudentCreateRequestDTO requestDTO) {
//        Student student = requestDTO.dtoToModel();
//
//
//
//    }
//
//    @PostMapping("/update")
//
//    @PostMapping("/delete")

}