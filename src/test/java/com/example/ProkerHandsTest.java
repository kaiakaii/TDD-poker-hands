package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProkerHandsTest {
    private Process process = new Process();
    @Test
    void should_return_winer_when_process_given_two_high_card() {
        //given
        String white = "QD AS 4H 6H 7C";
        String black = "5D 2D 7H QD 6S";
        //when
        String winner = process.start(white,black);
        //then
        assertEquals(winner,"white wins");
    }

    @Test
    void should_return_winner_when_process_given_pair_and_high_card() {
        //given
        String white = "QD QS 4H 6H 7C";
        String black = "5D 2D 7H QD 6S";
        //when
        String winner = process.start(white,black);
        //then
        assertEquals("white wins",winner);
    }

    @Test
    void should_return_winner_when_process_given_pair_and_two_pairs() {
        //given
        String white = "QD QS 4H 6H 7C";
        String black = "5D 6D 5H QD 6S";
        //when
        String winner = process.start(white,black);
        //then
        assertEquals("black wins",winner);
    }

    @Test
    void should_return_winner_when_process_given_two_pairs_and_three_of_a_kind() {
        //given
        String white = "QD QS QH 6H 7C";
        String black = "5D 6D 3H QD 6S";
        //when
        String winner = process.start(white,black);
        //then
        assertEquals("white wins",winner);
    }

    @Test
    void should_return_winner_when_process_given_three_of_a_kind_and_straight() {
        //given
        String white = "QD QS QH 6H 7C";
        String black = "5D 6D 7H 8D 9S";
        //when
        String winner = process.start(white,black);
        //then
        assertEquals("black wins",winner);

    }
    @Test
    void should_return_winner_when_process_given_three_of_flush_and_straight() {
        //given
        String white = "QH 2H 4H 6H 7H";
        String black = "5D 6D 7H 8D 9S";
        //when
        String winner = process.start(white,black);
        //then
        assertEquals("white wins",winner);

    }
    @Test
    void should_return_winner_when_process_given_flush_and_full_house() {
        //given
        String white = "QH 2H 4H 6H 7H";
        String black = "5D 6D 5H 6S 5S";
        //when
        String winner = process.start(white,black);
        //then
        assertEquals("black wins",winner);

    }
    @Test
    void should_return_winner_when_process_given_four_kinds_and_full_house() {
        //given
        String white = "2H 2C 2D 2S 7H";
        String black = "5D 6D 5H 6S 5S";
        //when
        String winner = process.start(white,black);
        //then
        assertEquals("white wins",winner);

    }
    @Test
    void should_return_winner_when_process_given_four_kinds_and_straight_flush() {
        //given
        String white = "3H 4H 5H 6H 7H";
        String black = "2H 2C 2D 2S 7H";
        //when
        String winner = process.start(white,black);
        //then
        assertEquals("white wins",winner);

    }
}
