package com.example.preAcademicInfo.repository;

import com.example.preAcademicInfo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
