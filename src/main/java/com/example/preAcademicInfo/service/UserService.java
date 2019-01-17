package com.example.preAcademicInfo.service;

import com.example.preAcademicInfo.error.ValidationError;
import com.example.preAcademicInfo.model.Student;
import com.example.preAcademicInfo.model.User;
import com.example.preAcademicInfo.repository.StudentRepository;
import com.example.preAcademicInfo.repository.UserRepository;
import com.example.preAcademicInfo.utils.EnvUtil;
import com.example.preAcademicInfo.utils.FormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final PasswordEncoder encoder;
    private Environment env;
    private final EnvUtil environment;

    @Autowired
    public UserService(UserRepository userRepository, StudentRepository studentRepository, PasswordEncoder encoder, EnvUtil environment) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.encoder = encoder;
        this.environment = environment;
        env = environment.getEnv();
    }

    public User findByUsername(String username) {
        if (username != null) {
            return userRepository.findByUsername(username);
        }
        return null;
    }

    public void createUser(User user) {
        try {
            if (user != null) {
                if (user.getPassword() != null) {
                    user.setPassword(encoder.encode(user.getPassword()));
                }
                user.setId(null);
                userRepository.save(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User verifyLogin(User user, ValidationError error) {
        User userForLogin = null;
        if (user != null &&
                user.getUsername() != null && user.getPassword() != null) {
            userForLogin = userRepository.findByUsername(user.getUsername());
            if (userForLogin != null) {
                if (!encoder.matches(user.getPassword(), userForLogin.getPassword())) {
                    error =  new ValidationError("user.password.match", env);
                }
            } else {
                error = new ValidationError("user.notFound", env);
            }
        } else {
            error = new ValidationError("user.notValid", env);
        }
        return userForLogin;
    }

    public void save(User user, List<Error> errors) {
        if (user.getId() != null) {
            user.setId(null);
        }
        validateUser(user, errors);
        if (errors.isEmpty()) {
            userRepository.save(user);
        }
    }

    private void validateUser(User user, List<Error> errors) {
        validateUsername(user.getUsername(), errors);
        validatePassword(user.getPassword(), errors);
        validateEmail(user.getEmail(), errors);
    }

    private void validatePassword(String password, List<Error> errors) {
        if (!FormatUtils.isNullOrEmpty(password)) {
            if (!FormatUtils.isValidInput(password)) {
                errors.add(new Error("Password is not valid"));
            }
        } else {
            errors.add(new Error("Password is required"));
        }
    }

    private void validateEmail(String email, List<Error> errors) {
        if (FormatUtils.isNullOrEmpty(email)) {
            errors.add(new Error("Email is required"));
        }
    }

    private void validateUsername(String username, List<Error> errors) {
        if (!FormatUtils.isNullOrEmpty(username)) {
            if (!FormatUtils.isValidInput(username)) {
                errors.add(new Error("Username is not valid"));
            }
        } else {
            errors.add(new Error("Username is required"));
        }
    }


    public void createPasswordChangeRequest(String email, String nrMatricol, String newPassword, List<Error> errors) {

        if (!FormatUtils.isNullOrEmpty(email)
                && !FormatUtils.isNullOrEmpty(nrMatricol) && !FormatUtils.isNullOrEmpty(newPassword)){

            Student student = studentRepository.findStudentByNrMatricolAndEmail(nrMatricol,email);
            User user = student.getUser();
            if (user != null && user.getEmail().equals(student.getEmail())){
                String random = FormatUtils.getRandomString();
                user.setPassword(encoder.encode(random));
                user.setDisabled(true);
                studentRepository.save(student);
                //send mail with new password
            }else{
                errors.add(new Error("user.notFound"));
            }
        }
    }

    public User findLoggedUser(String username, String role) {
        return userRepository.findByUsernameAndProfile(username, role);
    }
}
