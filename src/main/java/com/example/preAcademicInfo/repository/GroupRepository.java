package com.example.preAcademicInfo.repository;

import com.example.preAcademicInfo.model.Bracket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Bracket, Long> {
}
