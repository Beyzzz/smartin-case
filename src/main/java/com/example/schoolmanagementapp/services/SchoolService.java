package com.example.schoolmanagementapp.services;

import com.example.schoolmanagementapp.dtos.SchoolUpdateDto;
import com.example.schoolmanagementapp.entities.School;

import java.util.List;

public interface SchoolService {

    List<School> findAll();
    School findById(Long id);

    School save(School school);

    void deleteById(Long id);

    School update(Long id, SchoolUpdateDto schoolUpdateDto);

}
