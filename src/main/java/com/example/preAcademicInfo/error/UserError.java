package com.example.preAcademicInfo.error;

public class UserError extends Error {

    public UserError(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
