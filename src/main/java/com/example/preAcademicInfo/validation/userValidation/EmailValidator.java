package com.example.preAcademicInfo.validation.userValidation;

import com.example.preAcademicInfo.utils.FormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    @Override
    public void initialize(ValidEmail constraintAnnotation) {

    }
    @Autowired
    private Environment env;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        String emailRegex = env.getProperty("email.regexp");
        if (FormatUtils.isNullOrEmpty(value)){
            return false;
        }
        if (emailRegex == null){
            return false;
        }
        return value.matches(emailRegex);
    }
}
