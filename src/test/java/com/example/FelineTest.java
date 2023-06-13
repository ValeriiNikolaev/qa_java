package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void eatMeatTests() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat());
    }

    @Test
    public void getFamilyTests() {
        String expectedFamily = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals(expectedFamily, actual);
    }


    @Test
    public void getKittensTests() {
        int actual = feline.getKittens();
        assertEquals(1, actual);
    }

    @Test
    public void getKittensCountTests() {
        int count = 10;
        int actual = feline.getKittens(count);
        assertEquals(count, actual);
    }

}
