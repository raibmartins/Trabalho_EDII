package com.matheusrai;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegisterParser {

    private Map<String, Object> parseRow(String row) {
        RegisterType registerType = RegisterType.toEnum(row);
        Map<String, Object> map = new HashMap<>();
        for (Field campo : registerType.getCampos()) {
            String value = row.substring(campo.getStart(),campo.getEnd());
            if(campo.getaClass().equals(String.class)) {
                map.put(campo.getKey(), value.trim());
            } else {
                map.put(campo.getKey(), Integer.parseInt(value));
            }
        }
        return map;
    }

    public List<Map<String,Object>> importFile(String path) throws IOException {
        File file = new File(path);
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String row;
        List<Map<String, Object>> list = new ArrayList<>();
        while ((row = bufferedReader.readLine()) != null) {
            list.add(parseRow(row));
        }
        return list;
    }

}
