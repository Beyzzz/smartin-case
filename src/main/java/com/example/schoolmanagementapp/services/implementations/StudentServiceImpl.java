package com.example.schoolmanagementapp.services.implementations;

import com.example.schoolmanagementapp.dtos.StudentCreateDto;
import com.example.schoolmanagementapp.dtos.StudentUpdateDto;
import com.example.schoolmanagementapp.entities.Student;
import com.example.schoolmanagementapp.repositories.StudentRepository;
import com.example.schoolmanagementapp.services.SchoolService;
import com.example.schoolmanagementapp.services.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final SchoolService schoolService;

    public StudentServiceImpl(StudentRepository studentRepository, SchoolService schoolService) {
        this.studentRepository = studentRepository;
        this.schoolService = schoolService;
    }

    @Override
    public List<Student> findAll() {

        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student could not be found"));
    }

    @Override
    public Student save(StudentCreateDto studentCreateDto) {

        Student student = Student.builder().firstName(studentCreateDto.getFirstName())
                .lastName(studentCreateDto.getLastName())
                .classroom(studentCreateDto.getClassroom())
                .school(schoolService.findById(studentCreateDto.getSchoolId()))
                .build();
        return studentRepository.save(student);

    }

    @Override
    public Student deleteById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student could not be found"));
        studentRepository.delete(student);
        return student;
    }

    @Override
    public Student update(Long id, StudentUpdateDto studentUpdateDto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student could not be found"));
        student.setFirstName(studentUpdateDto.getFirstName() == null ? student.getFirstName() : studentUpdateDto.getFirstName());
        student.setLastName(studentUpdateDto.getLastName() == null ? student.getLastName() : studentUpdateDto.getLastName());
        student.setClassroom(studentUpdateDto.getClassroom() == null ? student.getClassroom() : studentUpdateDto.getClassroom());
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findByClassroom(String classroom) {
        return studentRepository.findAllByClassroom(classroom);
    }


}
