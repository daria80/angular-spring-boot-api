package com.github.daria80.app.controller;

import com.github.daria80.app.models.Student;
import com.github.daria80.app.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student saveOrUpdate(@RequestBody Student student) {
        return studentService.saveOrUpdate(student);
    }

    @GetMapping
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable String id) {
        return  studentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        studentService.deleteById(id);
    }


}


