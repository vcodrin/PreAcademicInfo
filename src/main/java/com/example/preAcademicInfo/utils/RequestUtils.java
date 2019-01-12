package com.example.preAcademicInfo.utils;

import com.example.preAcademicInfo.bases.AbstractConstant;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class RequestUtils {

    public static Map<String,String[]> getParametersValues(AbstractConstant[] names, HttpServletRequest request){
        Map<String,String[]> values = new HashMap<>();
        for (AbstractConstant constant : names){
            String[] val = request.getParameterValues(constant.getName());
            values.put(constant.getName(), (val != null ? val : new String[0]));
        }
        return values;
    }

}
