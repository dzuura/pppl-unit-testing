import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExceptionsTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setUpAll() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @BeforeEach
    public void setUpEach() {
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
    }

    @AfterAll
    public static void tearDownAll() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Order(1)
    public void testCase1_NoSuchElementException() {
        // Klik tombol Tambah
        driver.findElement(By.id("add_btn")).click();

        // Tunggu kolom input baris 2
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement row2Input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']//input[@class='input-field']")));

//        WebElement row2Input = driver.findElement(By.xpath("//div[@id='row2']//input[@class='input-field']"));

        // Verifikasi kolom input baris 2 muncul
        Assertions.assertTrue(row2Input.isDisplayed(), "Kolom input baris 2 seharusnya muncul");
    }

    @Test
    @Order(2)
    public void testCase3_InvalidElementStateException() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Klik tombol Edit
        driver.findElement(By.id("edit_btn")).click();

        // Interaksi dengan kolom input
        WebElement input = driver.findElement(By.xpath("//div[@id='row1']//input[@class='input-field']"));
        input.click();
        input.clear();
        input.sendKeys("Burger");

        // Verifikasi nilai input
        Assertions.assertEquals("Burger", input.getAttribute("value"));
    }

    @Test
    @Order(3)
    public void testCase4_StaleElementReferenceException() throws InterruptedException {
        // Cari teks instruksi
        WebElement instructions = driver.findElement(By.id("instructions"));

        // Klik tombol Tambah
        driver.findElement(By.id("add_btn")).click();

        // Tunggu 5 detik
        Thread.sleep(5000);

//        boolean isDisplayed = instructions.isDisplayed();
//        Assertions.fail("Seharusnya memunculkan StaleElementReferenceException, tetapi elemen masih terlihat: " + isDisplayed);

        // Verifikasi instruksi tidak muncul
        Assertions.assertEquals(driver.findElements(By.id("instructions")).size(), 0, "Elemen instruksi seharusnya tidak muncul");
    }

    @Test
    @Order(4)
    public void testCase5_TimeoutException() {
        // Klik tombol Tambah
        driver.findElement(By.id("add_btn")).click();

        // Tunggu 5 detik
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement row2Input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']//input[@class='input-field']")));

        // Verifikasi kolom input baris 2 muncul
        Assertions.assertTrue(row2Input.isDisplayed(), "Kolom input baris 2 seharusnya muncul");
    }
}