package com.ladera.telecom;

import java.util.*;
import java.util.stream.Collectors;


import static java.util.stream.Collectors.toList;

public class Java {
    public static void main(String[] args) {
        Map<String,Integer> map = new LinkedHashMap<>();
        map.put("Rahul",10000);
        map.put("siva",20000);
        map.put("ramesh",30000);
        map.put("vignesh",40000);
        map.put("vel",50000);
        map.put("elumlai",50000);

        Map.Entry<Integer, List<String>> integerListEntry = getIntegerListEntry (3,map);

        System.out.println(integerListEntry);

    }

    private static Map.Entry<Integer, List<String>> getIntegerListEntry(int num,Map<String, Integer> map) {

        return map.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue
                        , Collectors.mapping(Map.Entry::getKey, toList())))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .toList().get(num-1);
    }

}
