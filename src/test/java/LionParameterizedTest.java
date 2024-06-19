import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

// Аннотация @RunWith сообщает JUnit использовать Parameterized тестовый класс
@RunWith(Parameterized.class)
public class LionParameterizedTest {
    // Аннотация @Mock создаёт мок-объект класса Feline
    @Mock
    private Feline feline;

    // Объявляем переменные для объекта Lion, пола льва и наличия гривы
    private Lion lion;
    private boolean doesHaveMane;
    private String sex;


    public LionParameterizedTest(String sex, boolean doesHaveMane) {
        this.sex = sex;
        this.doesHaveMane = doesHaveMane;
    }

    // Метод, помеченный аннотацией @Before, выполняется перед каждым тестом
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        lion = new Lion(sex, feline);
    }

    // Аннотация @Parameterized.Parameters указывает, что этот метод предоставляет параметры для тестов
    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][] {
                { "Самец", true },
                { "Самка", false }
        });
    }

    // Тестовый метод для проверки метода doesHaveMane() класса Lion
    @Test
    public void testDoesHaveMane() {
        boolean actualHasMane = lion.doesHaveMane();
        assertEquals(doesHaveMane, actualHasMane);
    }
}