package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Тесты для задачи 7 темы "Основы Java"

class MainTest {
    int[] order = new int[3];

    @Test
    void calculateOrder() {
        order[0] = 5;
        order[1] = 5;
        order[2] = 5;
        int expected = 3000;
        int actual = Main.calculateOrder(order);
        assertEquals(expected, actual);
    }

    @Test
    void addToOrder() {
        String input = "1 2";
        int[] expected = {2, 0, 0};
        int[] actual = Main.addToOrder(input, order);
        assertArrayEquals(expected, actual);
    }
}