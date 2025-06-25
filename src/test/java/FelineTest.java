import com.example.Feline;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    @Test
    public void testEatMeatReturnsMeatList() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testGetFamilyReturnsFelineFamily() {
        Feline feline = new Feline();
        String actualFamily = feline.getFamily();
        assertEquals("Кошачьи", actualFamily);
    }

    @Test
    public void testGetKittensReturnsOne() {
        Feline feline = new Feline();
        int actualKittens = feline.getKittens();
        assertEquals(1, actualKittens);
    }
}