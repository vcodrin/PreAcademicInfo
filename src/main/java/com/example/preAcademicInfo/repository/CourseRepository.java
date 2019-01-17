package com.example.preAcademicInfo.repository;

import com.example.preAcademicInfo.model.Course;
import com.example.preAcademicInfo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
