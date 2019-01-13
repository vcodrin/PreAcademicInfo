package com.example.preAcademicInfo.validation.userValidation;

import com.example.preAcademicInfo.utils.FormatUtils;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(ValidPassword constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !FormatUtils.isNullOrEmpty(value);
    }
}
