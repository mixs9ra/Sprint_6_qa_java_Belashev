import com.example.Animal;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

// Аннотация @RunWith сообщает JUnit использовать MockitoJUnitRunner
@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    // Аннотация @Mock создаёт мок-объект класса Animal
    @Mock
    private Animal animal;

    private Feline feline;

    // Метод @Before выполняется перед каждым тестом
    @Before
    public void setUp() {
        feline = new Feline();
    }

    // Тестовый метод для проверки метода eatMeat() класса Feline
    @Test
    public void testEatMeat() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");

        // Настраиваем мок-объект, чтобы метод getFood("Хищник") возвращал ожидаемый список еды
        Mockito.lenient().when(animal.getFood("Хищник")).thenReturn(expectedFood);

        List<String> actualFood = feline.eatMeat();

        assertEquals(expectedFood, actualFood);
    }

    // Тестовый метод для проверки метода getFamily() класса Feline
    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    // Тестовый метод для проверки метода getKittens() класса Feline
    @Test
    public void testGetKittens() {
        assertEquals(1, feline.getKittens());
    }
}