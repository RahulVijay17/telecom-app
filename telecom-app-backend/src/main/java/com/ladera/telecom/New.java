package com.ladera.telecom;

import java.util.*;
import java.util.stream.Collectors;

public class New {
    public static void main(String[] args) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        map.put("awanit", new ArrayList<>(Arrays.asList("978", "789")));
        map.put("alok", new ArrayList<>(Arrays.asList("678", "123")));

        Map<String, List<ArrayList<String>>> result = map.entrySet()
                .stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                ));

        result.forEach((key, value) -> {
            System.out.print(key + " ");
            value.forEach(System.out::print);
            System.out.println();
        });
    }
}
