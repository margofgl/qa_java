import com.example.Alex;
import com.example.Feline;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AlexTest {

    private Feline felineMock;

    @Before
    public void setUp() {
        felineMock = Mockito.mock(Feline.class);
    }

    @Test
    public void testAlexDoesHaveMane() throws Exception {
        Alex alex = new Alex(felineMock);
        boolean hasMane = alex.doesHaveMane();
        assertTrue(hasMane);
    }

    @Test
    public void testAlexGetKittensReturnsZero() throws Exception {
        Alex alex = new Alex(felineMock);
        int kittens = alex.getKittens();
        assertEquals(0, kittens);
    }

    @Test
    public void testAlexGetFriends() throws Exception {
        Alex alex = new Alex(felineMock);
        List<String> expectedFriends = Arrays.asList("Марти", "Глория", "Мелман");
        List<String> actualFriends = alex.getFriends();
        assertEquals(expectedFriends, actualFriends);
    }

    @Test
    public void testAlexGetPlaceOfLiving() throws Exception {
        Alex alex = new Alex(felineMock);
        String place = alex.getPlaceOfLiving();
        assertEquals("Нью-Йоркский зоопарк", place);
    }

    @Test
    public void testAlexGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Стейки", "Рыба", "Крылышки");
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(expectedFood);

        Alex alex = new Alex(felineMock);
        List<String> actualFood = alex.getFood();
        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void testAlexGetKittensFromMockDoesNotAffectAlex() throws Exception {
        Mockito.when(felineMock.getKittens()).thenReturn(1000);

        Alex alex = new Alex(felineMock);
        int kittens = alex.getKittens();

        assertEquals(0, kittens);
    }
}