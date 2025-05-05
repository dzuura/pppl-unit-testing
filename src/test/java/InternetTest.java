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
        driver.get("https://the-internet.herokuapp.com");
    }

    @Test
    @DisplayName("Hover on First Image")
    void testHoverFirstImage() {
        // Navigasi
        driver.findElement(By.linkText("Hovers")).click();
        // Locator
        WebElement firstImage = driver.findElement(By.cssSelector(".figure img"));
        Actions actions = new Actions(driver);
        actions.moveToElement(firstImage).perform();
        // Locator
        WebElement nameText = driver.findElement(By.className("figcaption")).findElement(By.tagName("h5"));
        Assertions.assertEquals("name: user1", nameText.getText());
    }

    @Test
    @DisplayName("Drag and Drop")
    void testDragAndDrop() {
        // Navigasi
        driver.findElement(By.linkText("Drag and Drop")).click();
        // Locator
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
        // Navigasi
        driver.findElement(By.linkText("Key Presses")).click();
        // Locator
        WebElement inputField = driver.findElement(By.id("target"));
        inputField.sendKeys(Keys.SHIFT);
        WebElement resultText = driver.findElement(By.id("result"));
        Assertions.assertEquals("You entered: SHIFT", resultText.getText());
    }

    @AfterEach
    void tearDown() {
        driver.navigate().back();
    }

    @AfterAll
    static void cleanup() {
        driver.quit();
        driver = null;
    }
}
