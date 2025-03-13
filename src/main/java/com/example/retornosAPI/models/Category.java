package com.example.retornosAPI.models;

public enum Category {
    ELETRONICO,
    ROUPA,
    ALIMENTO,
    OUTRO;
    public static boolean isValidEnum(String value) {
        try {
            Category.valueOf(value.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
