package com.example.schoolmanagementapp.controllers;

import com.example.schoolmanagementapp.dtos.SchoolUpdateDto;
import com.example.schoolmanagementapp.entities.School;
import com.example.schoolmanagementapp.entities.Student;
import com.example.schoolmanagementapp.services.SchoolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }
    @GetMapping
    public List<School> findAll(){
        return schoolService.findAll();
    }
    @GetMapping("/{id}")
    public School findById(@PathVariable Long id){
        return schoolService.findById(id);
    }
    @DeleteMapping("deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        schoolService.deleteById(id);
    }
    @PutMapping("update/{id}")
    public School update(@PathVariable Long id, @RequestBody SchoolUpdateDto schoolUpdateDto){
        return schoolService.update(id,schoolUpdateDto );
    }
    @PostMapping
    public School save(@RequestBody School school){
        return schoolService.save(school);
    }




}
