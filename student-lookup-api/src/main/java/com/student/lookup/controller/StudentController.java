package com.student.lookup.controller;

import com.student.lookup.model.ErrorResponse;
import com.student.lookup.model.Response;
import com.student.lookup.model.Student;
import com.student.lookup.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/all-students")
    public List<Student> getAllStudents() {
        return studentService.getStudentList();
    }

    @PostMapping("/students/{id}")
    public ResponseEntity fetchStudentInfo(@PathVariable("id") int id) {
        Student student = studentService.getStudentInfo(id);
        if (student == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new Response(null, new ErrorResponse(String.valueOf(id), HttpStatus.BAD_REQUEST, "Bad Request")));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(new Response(student, null));
    }
}
