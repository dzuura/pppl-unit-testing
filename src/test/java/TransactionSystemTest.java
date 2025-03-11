import org.example.TransactionSystem;
import org.junit.jupiter.api.*;

public class TransactionSystemTest {
    private static TransactionSystem ts;

    @BeforeAll
    static void setup() {
        TransactionSystem.openConnection();
    }

    @BeforeEach
    public void setupMethod() {
        ts = new TransactionSystem(50000);
    }

    @Test
    void testDeposit() {
        ts.deposit(100000);
        Assertions.assertEquals(150000, ts.getBalance());
    }

    @Test
    void testWithdraw() {
        ts.deposit(1000000);
        ts.withdraw(100000);
        Assertions.assertEquals(950000, ts.getBalance());
    }

    @AfterEach
    void cleanupMethod() {
        //
    }

    @AfterAll
    static void celanup() {
        ts = null;
        TransactionSystem.closeConnection();
    }
}
