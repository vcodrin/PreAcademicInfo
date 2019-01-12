package com.example.preAcademicInfo.error;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.env.Environment;

@Getter
@Setter
public class ValidationError {

    public ValidationError(String label, Environment env){
        this.label = label;
        if (env.containsProperty(label)) {
            this.message = env.getProperty(label);
        }else{
            this.message = label;
        }
    }

    public ValidationError() {
    }

    private String label;
    private String message;

    public boolean isEmpty(){
        return label == null  || label.isEmpty();
    }


}
