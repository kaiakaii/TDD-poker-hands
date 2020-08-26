package com.example;

import java.util.*;
import java.util.stream.Collectors;

import static com.example.Level.*;


public class Process {
    private static final String WHITE_WINS = "white wins";
    private static final String BLACK_WINS = "black wins";
    private List<Card> whiteCards = new ArrayList<Card>();
    private List<Card> blackCards = new ArrayList<Card>();
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
        whiteCards = whiteCards.stream().sorted((e1, e2) -> e1.getIndex() - e2.getIndex()).collect(Collectors.toList());
        blackCards = blackCards.stream().sorted((e1, e2) -> e1.getIndex() - e2.getIndex()).collect(Collectors.toList());
        int whiteLevel = getCardsLevel(whiteCards);
        int blackLevel = getCardsLevel(blackCards);
        if (whiteLevel > blackLevel) {
            return WHITE_WINS;
        } else if (whiteLevel < blackLevel) {
            return BLACK_WINS;
        } else {
            return dealSameLevel();
        }
    }

    private String dealSameLevel() {
        if (whiteCards.get(whiteCards.size() - 1).getIndex() > blackCards.get(blackCards.size() - 1).getIndex()) {
            return WHITE_WINS;
        } else {
            return BLACK_WINS;
        }
    }

    private int getCardsLevel(List<Card> cards) {
        if (isStraight(cards)){
            return 5;
        }
        if (isThreeKinds(cards)){
            return 4;
        }
        if (isTwoPair(cards)) {
            return 3;
        }
        if (isPair(cards)) {
            return 2;
        }
        return 1;
    }

    private void initCarList(String white, String black) {
        Arrays.stream(white.split(" "))
                .forEach(
                        el -> whiteCards.add(new Card(String.valueOf(el.charAt(0)), String.valueOf(el.charAt(1)), maps.get(String.valueOf(el.charAt(0)))))
                );
        Arrays.stream(black.split(" "))
                .forEach(
                        el -> blackCards.add(new Card(String.valueOf(el.charAt(0)), String.valueOf(el.charAt(1)), maps.get(String.valueOf(el.charAt(0)))))
                );
    }
}
