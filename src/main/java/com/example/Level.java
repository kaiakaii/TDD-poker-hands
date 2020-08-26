package com.example;

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
}
