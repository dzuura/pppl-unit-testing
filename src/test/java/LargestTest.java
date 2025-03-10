import org.example.Largest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LargestTest {
    @Test
    void testLargest() {
        int[] arr = { 1, 2, 3, 4, 5 };
        Assertions.assertEquals(5, Largest.largest(arr));
    }

//    @Test
//    void test() {
//        Wallet wallet = new Wallet();
//        Wallet bank = new Wallet();
//        wallet.addMoney(0,2);
//        bank.addMoney(0,2);
////        int a = 1;
////        a = b;
////        b = a;
//        Assertions.assertSame(bank.getTotalMoney(),wallet.getTotalMoney());
//    }
}
