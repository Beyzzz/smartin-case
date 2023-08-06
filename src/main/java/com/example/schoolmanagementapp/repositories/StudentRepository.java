package com.example.schoolmanagementapp.repositories;

import com.example.schoolmanagementapp.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByClassroom(String classroom);
}
