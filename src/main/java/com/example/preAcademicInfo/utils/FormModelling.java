package com.example.preAcademicInfo.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FormModelling {


    public static Map<String, String> createFormAttributes(Class<?> clazz) {
        Map<String, String> formAttributes = new HashMap<>();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            StringBuilder builder = new StringBuilder();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Type) {
                    Type type = (Type) annotation;
                    builder.append("type=").append("\"").append(type.inputType()).append("\" ");
                    builder.append("path=").append("\"").append(type.path()).append("\" ");
                    populate(builder, type);
                    formAttributes.put(type.path(), builder.toString());
                } else if (annotation instanceof ModelClass) {
                    ModelClass modelClass = (ModelClass) annotation;
                    Field[] additionalFields = field.getType().getDeclaredFields();
                    for (Field f : additionalFields) {
                        StringBuilder b = new StringBuilder().append("path=").append("\"");
                        b.append(modelClass.name()).append(".");
                        Annotation[] annotations1 = f.getDeclaredAnnotations();
                        for (Annotation annotation1 : annotations1) {
                            if (annotation1 instanceof Type) {
                                Type type = (Type) annotation1;
                                b.append(type.path()).append("\" ");
                                b.append("type=").append("\"").append(type.inputType()).append("\" ");
                                populate(b, type);
                                formAttributes.put(modelClass.name() + "." + type.path(), b.toString());
                            }
                        }
                    }
                }
            }

        }
        return formAttributes;
    }

    private static void populate(StringBuilder builder, Type type) {
        if (type.attributes().length > 0) {
            String[] attributes = type.attributes();
            String[] values = type.values();
            for (int i = 0; i < attributes.length; i++) {
                builder.append(attributes[i]).append("=").append("\"").append(values[i]).append("\" ");
            }
        }
    }
}
