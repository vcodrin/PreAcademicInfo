package com.example.preAcademicInfo.error;

import org.springframework.core.env.Environment;

public class ValidationError {

    public ValidationError(String label, Environment env){
        this.label = label;
        if (env.containsProperty(label)) {
            this.message = env.getProperty(label);
        }else{
            this.message = label;
        }
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ValidationError() {
    }

    private String label;
    private String message;

    public boolean isEmpty(){
        return label == null  || label.isEmpty();
    }


    @Override
    public String toString() {
        return "ValidationError{" +
                "label='" + label + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
