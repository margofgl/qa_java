import com.example.Feline;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParamTest {

    private final int inputKittens;
    private final int expectedKittens;

    public FelineParamTest(int inputKittens, int expectedKittens) {
        this.inputKittens = inputKittens;
        this.expectedKittens = expectedKittens;
    }

    @Parameterized.Parameters(name = "Test getKittens({0}) = {1}")
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {0, 0},
                {1, 1},
                {5, 5},
                {10, 10}
        });
    }

    @Test
    public void testGetKittensWithArgument() {
        Feline feline = new Feline();
        int actual = feline.getKittens(inputKittens);
        assertEquals(expectedKittens, actual);
    }
}