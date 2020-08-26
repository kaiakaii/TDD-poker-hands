package com.example;

import java.util.*;
import java.util.stream.Collectors;

public class Process {
    private List<Car> whiteCars = new ArrayList<Car>();
    private List<Car> blackCars = new ArrayList<Car>();
    private final static Map<String, Integer> maps = new HashMap<String, Integer>();

    static {
        {
            for (int i = 2; i <= 9; i++) {
                maps.put(String.valueOf(i), i);
            }
            maps.put("T", 10);
            maps.put("J", 11);
            maps.put("Q", 12);
            maps.put("K", 13);
            maps.put("A", 14);
        }
    }

    public String start(String white, String black) {
        initCarList(white, black);
        whiteCars = whiteCars.stream().sorted((e1, e2) -> e1.getIndex() - e2.getIndex()).collect(Collectors.toList());
        blackCars = blackCars.stream().sorted((e1, e2) -> e1.getIndex() - e2.getIndex()).collect(Collectors.toList());
        if (whiteCars.get(whiteCars.size() - 1).getIndex() > blackCars.get(blackCars.size()-1).getIndex()){
            return "white wins";
        }else {
            return "black wins";
        }
    }

    private void initCarList(String white, String black) {
        Arrays.stream(white.split(" "))
                .forEach(
                        el -> whiteCars.add(new Car(String.valueOf(el.charAt(0)), String.valueOf(el.charAt(1)), maps.get(String.valueOf(el.charAt(0)))))
                );
        Arrays.stream(black.split(" "))
                .forEach(
                        el -> blackCars.add(new Car(String.valueOf(el.charAt(0)), String.valueOf(el.charAt(1)), maps.get(String.valueOf(el.charAt(0)))))
                );
    }
}
