package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTest {
    private final boolean expectedRes;
    private final String sex;

    @Mock
    Feline feline;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    public LionTest(String sex, boolean expectedRes){
        this.sex = sex;
        this.expectedRes = expectedRes;
    }

    @Parameterized.Parameters
    public static Object[][] params(){
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }


    @Test
    public void getKittens() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion(feline, sex);
        assertEquals(1, lion.getKittens());

    }

    @Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion(feline, sex);
        assertEquals(expectedRes, lion.doesHaveMane());
    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion(feline, sex);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}
