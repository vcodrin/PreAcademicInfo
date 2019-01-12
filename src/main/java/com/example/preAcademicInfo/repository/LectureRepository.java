package com.example.preAcademicInfo.repository;

import com.example.preAcademicInfo.model.lecture.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
