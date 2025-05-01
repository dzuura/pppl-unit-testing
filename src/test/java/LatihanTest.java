import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LatihanTest {
    private static WebDriver driver;

    @BeforeAll
    static void setup(){
        driver = new ChromeDriver();
    }

    @AfterAll
    static void cleanup() {
        driver.quit();
    }

    @Test
    public void testStart() {
        driver.get("https://www.google.com");
//        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

    }

    @Test
    public void testTitle() {
        driver.get("https://tedi.sv.ugm.ac.id/id/muka/");
        Assertions.assertEquals("Website Departemen Teknik Elektro dan Informatika (TEDI), Sekolah Vokasi, UGM – TEDI SV UGM", driver.getTitle());
    }

    @Test
    public void testURL() {
        driver.get("https://tedi.sv.ugm.ac.id/id/muka/");
        Assertions.assertEquals("https://tedi.sv.ugm.ac.id/id/muka/", driver.getCurrentUrl());
    }

}
