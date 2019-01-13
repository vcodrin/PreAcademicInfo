package com.example.preAcademicInfo.validation.userValidation;

import com.example.preAcademicInfo.utils.ContextProvider;
import com.example.preAcademicInfo.utils.EnvUtil;
import com.example.preAcademicInfo.utils.FormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    private EnvUtil env;

    @Override
    public void initialize(ValidEmail constraintAnnotation) {
        env = ContextProvider.getBean(EnvUtil.class);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        String emailRegex = env.getEnv().getProperty("email.regexp");
        if (FormatUtils.isNullOrEmpty(value)){
            return false;
        }
        if (emailRegex == null){
            return false;
        }
        return value.matches(emailRegex);
    }
}
