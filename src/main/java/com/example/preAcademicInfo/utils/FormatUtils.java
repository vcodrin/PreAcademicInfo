package com.example.preAcademicInfo.utils;

import java.util.UUID;

public class FormatUtils {

    private static EnvUtil env = ContextProvider.getBean(EnvUtil.class);

    public static boolean isNullOrEmpty(String string){
        return string == null || string.trim().isEmpty();
    }

    public static boolean isValidInput(String value){
        String reg = env.getEnv().getProperty("input.invalid");
        return reg == null || !value.trim().matches(reg);
    }

    public static String getRandomString(){
        UUID random = UUID.randomUUID();
        return random.toString();
    }

    public static Integer stringToInt(String s){
        if (!s.isEmpty()){
            return Integer.parseInt(s);
        }
        return null;
    }

    public static String capitalize(String s){
        if (!s.isEmpty()){
            return s.substring(0,1).toUpperCase().concat(s.substring(1));
        }
        return null;
    }

    public static Boolean integerBetweenRange(int val,int left, int right){
        return val >= left && val <= right;
    }
}
