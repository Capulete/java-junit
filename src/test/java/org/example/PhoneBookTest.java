package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Тесты для задачи 16 темы "Основы Java"

class PhoneBookTest {

    PhoneBook phoneBook = new PhoneBook();

    @Test
    void addGroup() {
        String nameGroup = "Коллеги";
        boolean expected = true;
        boolean actual = phoneBook.addGroup(nameGroup);
        assertEquals(expected, actual);
        assertEquals(nameGroup, phoneBook.groups.keySet().toArray()[0]);
    }

    @Test
    void findContactsByGroup() {
        String nameGroup = "Коллеги";
        List<Contact> expected = new ArrayList<>();
        expected.add(new Contact("Petya", "8-800-555-35-35"));
        phoneBook.groups.put(nameGroup, expected);
        List<Contact> actual = phoneBook.findContactsByGroup(nameGroup);
        assertEquals(expected, actual);
    }
}