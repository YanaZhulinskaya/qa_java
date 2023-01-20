package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import java.util.Objects;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void getKittens() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(food);

        assertTrue(Objects.equals(lion.getFood(), food));
    }

    @Test
    public void doesHaveManeCheckException() {
        Exception exception = assertThrows(Exception.class, () -> new Lion(feline, "Неопределен"));
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }
}