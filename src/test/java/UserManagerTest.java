import org.example.UserManager;
import org.junit.jupiter.api.*;

public class UserManagerTest {
    private static UserManager um;

    @BeforeAll
    static void setup(){
        um = new UserManager();
    }

    @BeforeEach
    public void setupMethod() {
        um.addName("zero");
    }

    @Test
    void testAddName() {
        um.addName("piaro");
        Assertions.assertTrue(um.userExist("piaro"));
    }

    @Test
    void testRemoveName() {
        um.removeName("zero");
        Assertions.assertEquals(0, um.getUserCount());
        Assertions.assertFalse(um.userExist("zero"));
    }

    @Test
    void testGetUserCount() {
        um.addName("assistant");
        Assertions.assertEquals(2, um.getUserCount());
    }

    @Test
    void testUserExist() {
        Assertions.assertEquals(1, um.getUserCount());
        Assertions.assertTrue(um.userExist("zero"));
    }

    @AfterEach
    void cleanupMethod() {
        um.clearUsername();
    }

    @AfterAll
    static void cleanup() {
        um = null;
    }
}
