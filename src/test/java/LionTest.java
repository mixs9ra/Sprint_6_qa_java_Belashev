import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// Аннотация @RunWith сообщает JUnit использовать MockitoJUnitRunner
@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    // Аннотация @Mock создаёт мок-объект класса Feline
    @Mock
    private Feline feline;

    private Lion lion;

    // Метод, помеченный аннотацией @Before, выполняется перед каждым тестом
    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самец", feline);
    }

    // Тестовый метод для проверки создания объекта Lion с некорректным полом
    @Test
    public void testWithInvalidSex() {
        assertThrows(Exception.class, () -> new Lion("InvalidSex", feline));
    }

    // Тестовый метод для проверки метода getFood() класса Lion
    @Test
    public void testGetFood() throws Exception {

        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");

        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);

        List<String> actual = lion.getFood();

        assertEquals(expectedFood, actual);
    }

    // Тестовый метод для проверки метода getKittens() класса Lion
    @Test
    public void testGetKittens() {

        int expectedKittensCount = 3;
        Mockito.when(feline.getKittens()).thenReturn(expectedKittensCount);
        int actualKittensCount = lion.getKittens();
        assertEquals(expectedKittensCount, actualKittensCount);
        Mockito.verify(feline).getKittens();
    }
}