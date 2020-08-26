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
}
