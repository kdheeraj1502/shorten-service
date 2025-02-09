package com.example.demo.utility;

import java.util.*;
import java.util.stream.Collectors;

public class MainAppNames {

    private static String[] name = {"A", "B", "B", "E", "D"};


    public String getNames() {
        Comparator<Map.Entry<String, Long>> comp = (a, b) -> a.getValue().compareTo(b.getValue());
        List<String> secondHighest =   Arrays.stream(name).collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet().stream().sorted(comp.reversed()).skip(0).map(e -> e.getKey())
                .collect(Collectors.toList());
        System.out.println(secondHighest.get(0));
        return secondHighest.get(0);
    }

    public static void main(String[] args) {
        MainAppNames mainApp = new MainAppNames();
        for(int i= 0; i < 5; i++){
          //  System.out.println(mainApp.randomFlag());
        }

        mainApp.getNames();

       String datas = Arrays.stream(name)
               .filter(ch -> ch.equalsIgnoreCase("B")).filter(Objects::nonNull)
               .map(ch -> "Ball").reduce((a, b) -> a).get();
        System.out.println(datas);


    }
}
