import org.example.Largest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LargestTest {
    @Test
    void testLargest() {
        int[] arr = { 1, 2, 3, 4, 5 };
        Assertions.assertEquals(5, Largest.largest(arr));
    }
}
