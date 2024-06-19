import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

// Аннотация @RunWith сообщает JUnit использовать Parameterized тестовый класс
@RunWith(Parameterized.class)
public class FelineParameterizedTest {
    // Объявляем объект Feline и переменную для ожидаемого значения котят
    private Feline feline;
    private int expectedKittens;

    // Конструктор класса принимает параметр ожидаемого значения котят
    public FelineParameterizedTest(int expectedKittens) {
        this.expectedKittens = expectedKittens;
    }

    // Метод @Before выполняется перед каждым тестом
    @Before
    public void setUp() {
        // новый объект Feline перед каждым тестом
        feline = new Feline();
    }

    // Аннотация @Parameterized.Parameters указывает, что этот метод предоставляет параметры для тестов
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        // Возвращаем коллекцию массивов объектов с параметрами для тестов
        return Arrays.asList(new Object[][] {
                { 5 },
                { 3 },
                { 1 }
        });
    }

    // Тестовый метод для проверки метода getKittens(int) класса Feline
    @Test
    public void testGetKittensWithParam() {
        int actualKittens = feline.getKittens(expectedKittens);

        // Проверяем, что фактическое значение котят соответствует ожидаемому
        assertEquals(expectedKittens, actualKittens);
    }
}