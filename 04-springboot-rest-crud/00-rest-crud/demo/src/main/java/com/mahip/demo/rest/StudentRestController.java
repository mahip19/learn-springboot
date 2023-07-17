package com.mahip.demo.rest;

import com.mahip.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    //    define @PostContruct to load student data -> only used once when bean is contructed
    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();
        students.add(new Student("Raj", "Khanna"));
        students.add(new Student("Kapil", "Sharma"));
        students.add(new Student("Raj", "Patel"));

    }

    //    define endpoints for "/student" -> all students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

//    define endpoint for "/students/{studentid"
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
//        keep it simple rn

//        check studentid valid
        if ((studentId > students.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("invalid studentId");
        }
        return students.get(studentId);
    }

//    add exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException( StudentNotFoundException exception){
        StudentErrorResponse stdex = new StudentErrorResponse();
        stdex.setMessage(exception.getMessage());
        stdex.setStatus(HttpStatus.NOT_FOUND.value());
        stdex.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(stdex, HttpStatus.NOT_FOUND);
    }
}
