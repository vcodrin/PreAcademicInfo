package com.example.preAcademicInfo.service;

import com.example.preAcademicInfo.constants.Profile;
import com.example.preAcademicInfo.model.Student;
import com.example.preAcademicInfo.model.User;
import com.example.preAcademicInfo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final PasswordEncoder encoder;

    @Autowired
    public StudentService(StudentRepository studentRepository, PasswordEncoder encoder) {
        this.studentRepository = studentRepository;
        this.encoder = encoder;
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveStudent(Student student, BindingResult bindingResult) {
        validateStudent(student, bindingResult);
        if (!bindingResult.hasErrors()) {
            User user = new User();
            user.setDisabled(false);
            user.setEmail(student.getEmail());
            user.setPassword(encoder.encode(student.getCnp()));
            user.setUsername(student.getLastName().substring(0,1).toLowerCase()
                    .concat(student.getFirstName()).toLowerCase()
                    .concat(student.getCnp().substring(0, 7)));
            user.setProfile(Profile.STUDENT.getName());
            student.setUser(user);
            user.setStudent(student);
            studentRepository.save(student);
        }
    }

    private void validateStudent(Student student, BindingResult bindingResult) {

    }

}
