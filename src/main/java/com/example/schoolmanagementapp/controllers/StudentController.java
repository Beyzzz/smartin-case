package com.example.schoolmanagementapp.controllers;

import com.example.schoolmanagementapp.dtos.StudentCreateDto;
import com.example.schoolmanagementapp.dtos.StudentUpdateDto;
import com.example.schoolmanagementapp.entities.Student;
import com.example.schoolmanagementapp.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> findAll() {
        return studentService.findAll();
    }
    @GetMapping("/{id}")
    public Student findById(@PathVariable Long id) {
        return studentService.findById(id);
    }
    @PostMapping
    public Student save(@RequestBody StudentCreateDto studentCreateRequestDto){
        return studentService.save(studentCreateRequestDto);
    }

    @DeleteMapping("deleteById/{id}")
    public Student deleteById(@PathVariable Long id){
        return studentService.deleteById(id);
    }

    @PutMapping("updateById/{id}")
    public Student update(@PathVariable Long id, @RequestBody StudentUpdateDto studentUpdateDto){
        return studentService.update(id, studentUpdateDto);
    }
    @GetMapping("getByClassroom")
    public List<Student> findByClassroom(@RequestParam String classroom){
        return studentService.findByClassroom(classroom);
    }
}
