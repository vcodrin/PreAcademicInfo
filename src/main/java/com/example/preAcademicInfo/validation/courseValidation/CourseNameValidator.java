package com.example.preAcademicInfo.validation.courseValidation;

import com.example.preAcademicInfo.utils.FormatUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseNameValidator implements ConstraintValidator<ValidCourseName, String> {
    @Override
    public void initialize(ValidCourseName constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (FormatUtils.isNullOrEmpty(value)) {
            return false;
        }
        return FormatUtils.isValidInput(value);
    }
}
