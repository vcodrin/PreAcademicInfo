package com.example.preAcademicInfo.repository;

import com.example.preAcademicInfo.model.laboratory.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaboratoryRepository extends JpaRepository<Laboratory, Long> {
}
