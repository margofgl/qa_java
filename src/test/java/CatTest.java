import com.example.Cat;
import com.example.Feline;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CatTest {

    @Test
    public void testGetSoundReturnsMeow() {
        Feline felineMock = Mockito.mock(Feline.class);
        Cat cat = new Cat(felineMock);
        String sound = cat.getSound();
        assertEquals("Мяу", sound);
    }

    @Test
    public void testGetFoodReturnsMeatList() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(felineMock);
        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood);
    }
}
