package com.anshumanprajapati;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();

        map.put("anshuman", new ArrayList<String>());
        map.put("anshuman2", new ArrayList<Integer>());
        Class<?> clazz = map.get("anshuman").getClass();
        Class<?> clazz2 = map.get("anshuman2").getClass();

        System.out.println("Class name: " + clazz.getName());
        System.out.println("Class name: " + clazz2.getName());

        if (map.get("anshuman") instanceof ArrayList<?>) {
            System.out.println("obj is an instance of String");
        }

        if (map.get("anshuman2") instanceof ArrayList<?>) {
            System.out.println("obj is an instance of Integer");
        }
    }
}