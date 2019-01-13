package com.example.preAcademicInfo.data;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Arrays;


@JacksonXmlRootElement(localName = "functions")
public class Functions {
    @JacksonXmlElementWrapper(useWrapping = false)
    private Function[] function;

    public Functions() {

    }

    public Functions(Function[] function) {
        this.function = function;
    }

    public Function[] getFunction() {
        return function;
    }

    public void setFunction(Function[] function) {
        this.function = function;
    }

    @Override
    public String toString() {
        return "Functions [function=" + Arrays.toString(function) + "]";
    }


}
