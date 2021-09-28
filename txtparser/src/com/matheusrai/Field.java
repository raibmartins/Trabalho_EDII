package com.matheusrai;

public class Field {

    private int start;
    private int end;
    private String key;
    private Class<?> aClass;

    public static Field build() {
        return new Field();
    }

    public Field start(int start) {
        this.start = start;
        return this;
    }

    public Field end(int end) {
        this.end = end;
        return this;
    }

    public Field key(String key) {
        this.key = key;
        return this;
    }

    public Field classe(Class<?> aClass) {
        this.aClass = aClass;
        return this;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String getKey() {
        return key;
    }

    public Class<?> getaClass() {
        return aClass;
    }
}
