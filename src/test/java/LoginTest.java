import com.aventstack.extentreports.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.saucedemo.LoginPage;
import pages.saucedemo.HomePage;
import utils.ExtentReportManager;
import utils.ScreenshotUtil;

public class LoginTest {
    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void setUp() {
        extent = ExtentReportManager.getInstance();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testLogin() {
        test = extent.createTest("My First Test", "Login with valid credential");

        LoginPage login = new LoginPage(driver);
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();

        HomePage home = new HomePage(driver);
        home.getTextProducts();

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(home.getActualUrl(), expectedUrl);

        test.log(Status.INFO, "Login successful");
    }

    @AfterMethod
    public void terminateBrowser(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Case Failed: " + result.getName());
            test.log(Status.FAIL, "Failure Reason: " + result.getThrowable());

            String screenshotPath = ScreenshotUtil.takeScreenshot(driver,
                    result.getName());
            try {
                test.addScreenCaptureFromPath(screenshotPath);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Case Passed: " + result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Case Skipped: " + result.getName());
        }

        driver.quit();
        test.log(Status.INFO, "Browser closed");
    }

    @AfterClass
    public void cleanUp() {
        extent.flush();
    }
}