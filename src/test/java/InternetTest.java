import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class InternetTest {
    private static WebDriver driver;

    @BeforeAll
    static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

//    @AfterEach
//    void tearDown() {
//        driver.navigate().back();
//    }

    @AfterAll
    static void cleanup() {
        driver.quit();
        driver = null;
    }

    @Test
    @DisplayName("Hover on First Image")
    void testHoverFirstImage() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement firstImage = driver.findElement(By.xpath("(//div[@class='figure'])[1]/img"));
        Actions actions = new Actions(driver);
        actions.moveToElement(firstImage).perform();
        WebElement nameText = driver.findElement(By.xpath("(//div[@class='figure'])[1]//h5"));
        Assertions.assertEquals("name: user1", nameText.getText());
    }

    @Test
    @DisplayName("Drag and Drop")
    void testDragAndDrop() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
        Assertions.assertEquals("B", source.getText());
        Assertions.assertEquals("A", target.getText());
    }

    @Test
    @DisplayName("Key Presses with SHIFT")
    void testKeyPresses() {
        driver.get("https://the-internet.herokuapp.com/key_presses");
        WebElement inputField = driver.findElement(By.id("target"));
        inputField.sendKeys(Keys.SHIFT);
        WebElement resultText = driver.findElement(By.id("result"));
        Assertions.assertEquals("You entered: SHIFT", resultText.getText());
    }
}
