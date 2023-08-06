package com.example.schoolmanagementapp.services;

import com.example.schoolmanagementapp.dtos.StudentCreateDto;
import com.example.schoolmanagementapp.dtos.StudentUpdateDto;
import com.example.schoolmanagementapp.entities.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();
    Student findById(Long id);

    Student save(StudentCreateDto studentCreateRequestDto);

    Student deleteById(Long id);

    Student update(Long id, StudentUpdateDto studentUpdateDto);

    List<Student> findByClassroom(String classroom);

}
