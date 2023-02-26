package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)

public class CatTest {
    Cat cat;

    @Mock
    Feline feline;

    @Test
    public void getSound() {
        cat = new Cat(feline);
        String actualResult = cat.getSound();
        assertEquals("Ожидался ответ МЯУ", "Мяу", actualResult);
    }

    @Test
    public void getFoodException() throws Exception  {
        cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = cat.getFood();
        assertEquals(expected, actual);
    }
}
