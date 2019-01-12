package com.example.preAcademicInfo.repository;

import com.example.preAcademicInfo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findStudentByNrMatricolAndEmail(String nrMatricol, String email);
}
