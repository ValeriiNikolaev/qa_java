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
import static org.junit.Assert.assertThrows;


@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final boolean hasMane;

    @Mock
    Feline feline;

    public LionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    // Тестовые данные
    @Parameterized.Parameters(name = "sex: {0}, expectedResult: {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Before
    public void setUp() {
        //noinspection deprecation
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getKittensTests() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualResult = lion.getKittens();
        assertEquals( 1, actualResult);
    }

    @Test
    public void doesHaveManeTests() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(hasMane, lion.doesHaveMane());
    }

    @Test
    public void unknownSexTests() {
        Exception thrown = assertThrows(
                Exception.class, () ->new Lion("Неизвестно", feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", thrown.getMessage());
    }

    @Test
    public void getFoodTests() throws Exception {
        Lion lion = new Lion(sex, feline);
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedResult);
        List<String> actualResult = lion.getFood();
        assertEquals( expectedResult, actualResult);
    }

}