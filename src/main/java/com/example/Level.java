package com.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Level {
    public static boolean isPair(List<Card> cards) {
        Set<Integer> cardIndexs = new HashSet<>();
        cards.forEach(card -> cardIndexs.add(card.getIndex()));
        if (cardIndexs.size() != cards.size()) {
            return true;
        }
        return false;
    }

    public static boolean isTwoPair(List<Card> cards) {
        HashMap<Integer, Integer> cardIndexTimes = new HashMap<>();
        for (Card card : cards) {
            Integer indexTime = cardIndexTimes.getOrDefault(card.getIndex(), 0);
            cardIndexTimes.put(card.getIndex(), indexTime + 1);
        }
        int flag = 0;
        for (Integer val : cardIndexTimes.values()) {
            if (val == 2) {
                flag++;
            }
        }
        return flag == 2;
    }

    public static boolean isThreeKinds(List<Card> cards) {
        Set<Integer> cardIndexs = new HashSet<>();
        cards.forEach(card -> cardIndexs.add(card.getIndex()));
        if (cards.size() - cardIndexs.size() == 2) {
            return true;
        }
        return false;
    }

    public static boolean isStraight(List<Card> cards) {
        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(i).getIndex()-cards.get(i-1).getIndex() != 1){
                return false;
            }
        }
        return true;
    }
    public static boolean isFlush(List<Card> cards) {
        Set<String> cardIndexs = new HashSet<>();
        cards.forEach(card -> cardIndexs.add(card.getFlowerColor()));
        if (cardIndexs.size() == 1) {
            return true;
        }
        return false;
    }
    public static boolean isFullHouse(List<Card> cards) {
        HashMap<Integer, Integer> cardIndexTimes = new HashMap<>();
        for (Card card : cards) {
            Integer indexTime = cardIndexTimes.getOrDefault(card.getIndex(), 0);
            cardIndexTimes.put(card.getIndex(), indexTime + 1);
        }
        int flag = 0;
        if(cardIndexTimes.size() != 2) {
            return false;
        }
        for (Integer val : cardIndexTimes.values()) {
            if (!(val == 2 || val == 3)) {
                flag++;
            }
        }
        return flag == 0;
    }
    public static boolean isFourKinds(List<Card> cards) {
        HashMap<Integer, Integer> cardIndexTimes = new HashMap<>();
        for (Card card : cards) {
            Integer indexTime = cardIndexTimes.getOrDefault(card.getIndex(), 0);
            cardIndexTimes.put(card.getIndex(), indexTime + 1);
        }
        int flag = 0;
        for (Integer val : cardIndexTimes.values()) {
            if (val == 4) {
                flag++;
            }
        }
        return flag == 1;
    }
}
