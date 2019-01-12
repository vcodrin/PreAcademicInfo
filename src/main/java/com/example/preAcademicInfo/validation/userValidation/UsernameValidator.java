package com.example.preAcademicInfo.validation.userValidation;

import com.example.preAcademicInfo.utils.EnvUtil;
import com.example.preAcademicInfo.utils.FormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<ValidUsername, String> {

    @Override
    public void initialize(ValidUsername constraintAnnotation) {

    }
    @Autowired
    private EnvUtil env;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

//        String userRegex = env.getEnv().getProperty("user.regexp");
//        if (!value.trim().isEmpty()){
//            return false;
//        }
//        if (userRegex != null && !value.matches(userRegex)) {
//            return false;
//        }
        if (FormatUtils.isNullOrEmpty(value)){
            return false;
        }
        if (!FormatUtils.isValidInput(value)){
            return false;
        }
        return true;
    }
}
