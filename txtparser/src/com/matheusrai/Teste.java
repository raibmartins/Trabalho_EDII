package com.matheusrai;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Teste {

    public static void main(String[] args) throws IOException {
        RegisterParser registerParser = new RegisterParser();
        List<Map<String, Object>> maps = registerParser.importFile("D:\\ler.txt");
        for (Map<String, Object> map : maps) {
            System.out.println(map.toString());
        }
    }
}
