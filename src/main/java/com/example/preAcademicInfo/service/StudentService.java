package com.example.preAcademicInfo.service;

import com.example.preAcademicInfo.model.Profile;
import com.example.preAcademicInfo.model.Student;
import com.example.preAcademicInfo.model.User;
import com.example.preAcademicInfo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final PasswordEncoder encoder;

    @Autowired
    public StudentService(StudentRepository studentRepository, PasswordEncoder encoder) {
        this.studentRepository = studentRepository;
        this.encoder = encoder;
    }


    public void saveStudent(Student student, List<Error> errors){
        validateStudent(student, errors);
        if (errors.isEmpty()){
            User user = new User();
            user.setDisabled(false);
            user.setEmail(user.getEmail());
            user.setPassword(encoder.encode(student.getCnp()));
            user.setUsername(student.getFirstName().concat(student.getLastName().concat(student.getCnp().substring(0,5))));
            user.setProfile(Profile.STUDENT.getName());
            student.setUser(user);
            studentRepository.save(student);
        }
    }

    private void validateStudent(Student student, List<Error> errors) {

        if (student == null){
            errors.add(new Error("student.isNull"));
        }else{
            validateName(student.getFirstName(), errors);
            validateName(student.getLastName(), errors);
            validateCnp(student.getCnp(), errors);
        }

    }

    private void validateCnp(String cnp, List<Error> errors) {
    }

    private void validateName(String firstName, List<Error> errors) {
    }


}
