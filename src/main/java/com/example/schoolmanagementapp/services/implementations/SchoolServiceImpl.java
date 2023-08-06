package com.example.schoolmanagementapp.services.implementations;

import com.example.schoolmanagementapp.dtos.SchoolUpdateDto;
import com.example.schoolmanagementapp.entities.School;
import com.example.schoolmanagementapp.repositories.SchoolRepository;
import com.example.schoolmanagementapp.services.SchoolService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public List<School> findAll() {
        return schoolRepository.findAll();
    }

    @Override
    public School findById(Long id) {
        return schoolRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("School could not be found"));
    }

    @Override
    public School save(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public void deleteById(Long id) {
        School school = schoolRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("School could not be found"));
        schoolRepository.delete(school);
    }

    @Override
    public School update(Long id, SchoolUpdateDto schoolUpdateDto) {
        School school = schoolRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("School could not be found"));
        school.setName(schoolUpdateDto.getName() == null ? school.getName() : schoolUpdateDto.getName());
        return schoolRepository.save(school);

    }


}
