package com.example.preAcademicInfo.data;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FunctionsSingletone {

    private static FunctionsSingletone functionsSingletone = new FunctionsSingletone();

    private List<Function> functions;

    private FunctionsSingletone() {

        Functions functions = null;

        JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        XmlMapper objectMapper = new XmlMapper(module);
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(".\\src\\main\\resources\\xml\\Functions.xml"));
            String a = StringUtils.toEncodedString(bytes, StandardCharsets.UTF_8);
            System.out.println(a);
            functions = objectMapper.readValue(a, Functions.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (functions == null)
            this.functions = null;
        else
            this.functions = Arrays.asList(functions.getFunction());
    }

    public static FunctionsSingletone getInstance() {
        return functionsSingletone;
    }

    public List<Function> getFunctions() {
        return functions;
    }


}
