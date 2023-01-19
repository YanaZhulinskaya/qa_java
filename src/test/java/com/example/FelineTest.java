package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineTest {
    private final int expectedKittensCount;
    private final int kittensCount;

    public FelineTest(int expectedKittensCount, int kittensCount) {
        this.expectedKittensCount = expectedKittensCount;
        this.kittensCount = kittensCount;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {1}, {2}")
    public static Object[][] params() {
        return new Object[][]{
                {1, 1},
                {2, 2},
        };
    }

    @Test
    public void eatMeat() throws Exception {
        Feline feline = new Feline();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void getFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittens() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        assertEquals(expectedKittensCount, feline.getKittens(kittensCount));
    }
}
