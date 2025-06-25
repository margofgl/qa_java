import com.example.Feline;
import com.example.Lion;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LionTest {

    private Feline felineMock;

    @Before
    public void setUp() {
        felineMock = Mockito.mock(Feline.class);
    }

    @Test
    public void testLionHasManeWhenMale() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        boolean hasMane = lion.doesHaveMane();
        assertTrue(hasMane);
    }

    @Test
    public void testLionHasNoManeWhenFemale() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        boolean hasMane = lion.doesHaveMane();
        assertFalse(hasMane);
    }

    @Test(expected = Exception.class)
    public void testLionThrowsExceptionWhenSexIsInvalid() throws Exception {
        new Lion("Неопознанный", felineMock);
    }

    @Test
    public void testLionGetKittens() throws Exception {
        Mockito.when(felineMock.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", felineMock);
        int actualKittens = lion.getKittens();
        assertEquals(3, actualKittens);
    }

    @Test
    public void testLionGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", felineMock);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
    }
}

