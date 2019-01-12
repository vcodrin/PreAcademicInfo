package com.example.preAcademicInfo.repository;

import com.example.preAcademicInfo.model.seminar.Seminar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeminarRepository extends JpaRepository<Seminar, Long> {
}
