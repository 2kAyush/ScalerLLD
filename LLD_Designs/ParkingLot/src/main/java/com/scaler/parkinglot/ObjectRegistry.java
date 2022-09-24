package com.scaler.parkinglot;

import java.util.*;

public class ObjectRegistry {
    private static Map<String, Object> objects = new HashMap<>();

    public static void put(String name, Object obj) {
        objects.put(name, obj);
    }

    public static Object get(String name) {
        return objects.get(name);
    }

}
