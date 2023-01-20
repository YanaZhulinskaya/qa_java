package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParamsTest {

    @Parameterized.Parameter()
    public String sex;

    @Parameterized.Parameter(1)
    public boolean doesHaveMane;

    @Mock
    Feline feline;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters(name = "Lion sex: {0}, expected for doesHaveMane(): {1}")
    public static Object[][] params() {
        return new Object[][] {
                { "Самец", true },
                { "Самка", false }
        };
    }

    @Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion(feline, sex);
        assertEquals(doesHaveMane, lion.doesHaveMane());
    }
}
