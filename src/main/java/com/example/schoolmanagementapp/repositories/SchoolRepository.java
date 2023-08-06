package com.example.schoolmanagementapp.repositories;

import com.example.schoolmanagementapp.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
