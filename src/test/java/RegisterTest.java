import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest {
    private WebDriver driver;
    private final String BASE_URL = "https://automationexercise.com/";
    private final String NAME = "Test User";
    private final String EMAIL = "testuser700@gmail.com";
    private final String PASSWORD = "password123";

    @BeforeEach
    public void setUp() {
        // 1. Launch browser
        driver = new EdgeDriver();
        Assertions.assertNotNull(driver);
    }

    @Test
    public void testUserRegistration() {
        // 2. Navigate to url
        driver.get(BASE_URL);
        Assertions.assertEquals(BASE_URL, driver.getCurrentUrl());

        // 3. Verify that home page is visible successfully
        WebElement homePageSlider = driver.findElement(By.id("slider"));
        Assertions.assertTrue(homePageSlider.isDisplayed());
        Assertions.assertEquals("slider", homePageSlider.getAttribute("id"));

        // 4. Click on 'Signup / Login' button
        WebElement signupLoginButton = driver.findElement(By.cssSelector("a[href='/login']"));
        signupLoginButton.click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("login"));

        // 5. Verify 'New User Signup!' is visible
        WebElement newUserSignupText = driver.findElement(By.cssSelector(".signup-form h2"));
        Assertions.assertTrue(newUserSignupText.isDisplayed());
        Assertions.assertEquals("New User Signup!", newUserSignupText.getText());

        // 6. Enter name and email address
        WebElement nameInput = driver.findElement(By.name("name"));
        WebElement emailInput = driver.findElement(By.cssSelector("input[data-qa='signup-email']"));

        nameInput.sendKeys(NAME);
        emailInput.sendKeys(EMAIL);

        Assertions.assertEquals(NAME, nameInput.getAttribute("value"));
        Assertions.assertEquals(EMAIL, emailInput.getAttribute("value"));

        // 7. Click 'Signup' button
        WebElement signupButton = driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
        Assertions.assertTrue(signupButton.isDisplayed());
        signupButton.click();

        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInfoText = driver.findElement(By.cssSelector(".title b"));
        Assertions.assertTrue(enterAccountInfoText.isDisplayed());
        Assertions.assertEquals("ENTER ACCOUNT INFORMATION", enterAccountInfoText.getText());

        // 9. Fill details: Title, Name, Email, Password, Date of birth
        // Select Title
        WebElement titleMr = driver.findElement(By.id("id_gender1"));
        titleMr.click();
        Assertions.assertTrue(titleMr.isSelected());

        // Password
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(PASSWORD);
        Assertions.assertEquals(PASSWORD, passwordInput.getAttribute("value"));

        // Date of birth (day, month, year)
        WebElement dayDropdown = driver.findElement(By.id("days"));
        WebElement monthDropdown = driver.findElement(By.id("months"));
        WebElement yearDropdown = driver.findElement(By.id("years"));

        Select daySelect = new Select(dayDropdown);
        daySelect.selectByValue("15");

        Select monthSelect = new Select(monthDropdown);
        monthSelect.selectByValue("6");

        Select yearSelect = new Select(yearDropdown);
        yearSelect.selectByValue("1990");

        Assertions.assertEquals("15", new Select(dayDropdown).getFirstSelectedOption().getAttribute("value"));
        Assertions.assertEquals("6", new Select(monthDropdown).getFirstSelectedOption().getAttribute("value"));
        Assertions.assertEquals("1990", new Select(yearDropdown).getFirstSelectedOption().getAttribute("value"));

        // 10. Select checkbox 'Sign up for our newsletter!'
        WebElement newsletterCheckbox = driver.findElement(By.id("newsletter"));
        newsletterCheckbox.click();
        Assertions.assertTrue(newsletterCheckbox.isSelected());

        // 11. Select checkbox 'Receive special offers from our partners!'
        WebElement offersCheckbox = driver.findElement(By.id("optin"));
        offersCheckbox.click();
        Assertions.assertTrue(offersCheckbox.isSelected());

        // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstNameInput = driver.findElement(By.id("first_name"));
        WebElement lastNameInput = driver.findElement(By.id("last_name"));
        WebElement companyInput = driver.findElement(By.id("company"));
        WebElement address1Input = driver.findElement(By.id("address1"));
        WebElement address2Input = driver.findElement(By.id("address2"));
        WebElement countryDropdown = driver.findElement(By.id("country"));
        WebElement stateInput = driver.findElement(By.id("state"));
        WebElement cityInput = driver.findElement(By.id("city"));
        WebElement zipcodeInput = driver.findElement(By.id("zipcode"));
        WebElement mobileNumberInput = driver.findElement(By.id("mobile_number"));

        firstNameInput.sendKeys("Test");
        lastNameInput.sendKeys("User");
        companyInput.sendKeys("Test Company");
        address1Input.sendKeys("Test Address");
        address2Input.sendKeys("Test Street");

        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText("United States");

        stateInput.sendKeys("California");
        cityInput.sendKeys("San Francisco");
        zipcodeInput.sendKeys("94105");
        mobileNumberInput.sendKeys("1234567890");

        Assertions.assertEquals("Test", firstNameInput.getAttribute("value"));
        Assertions.assertEquals("User", lastNameInput.getAttribute("value"));
        Assertions.assertEquals("Test Company", companyInput.getAttribute("value"));
        Assertions.assertEquals("Test Address", address1Input.getAttribute("value"));
        Assertions.assertEquals("Test Street", address2Input.getAttribute("value"));
        Assertions.assertEquals("United States", new Select(countryDropdown).getFirstSelectedOption().getText());
        Assertions.assertEquals("California", stateInput.getAttribute("value"));
        Assertions.assertEquals("San Francisco", cityInput.getAttribute("value"));
        Assertions.assertEquals("94105", zipcodeInput.getAttribute("value"));
        Assertions.assertEquals("1234567890", mobileNumberInput.getAttribute("value"));

        // 13. Click 'Create Account button'
        WebElement createAccountButton = driver.findElement(By.cssSelector("button[data-qa='create-account']"));
        Assertions.assertTrue(createAccountButton.isDisplayed());
        createAccountButton.click();

        // 14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreatedText = driver.findElement(By.cssSelector("h2[data-qa='account-created'] b"));
        Assertions.assertTrue(accountCreatedText.isDisplayed());
        Assertions.assertEquals("ACCOUNT CREATED!", accountCreatedText.getText());

        // 15. Click 'Continue' button
        WebElement continueButton = driver.findElement(By.cssSelector("a[data-qa='continue-button']"));
        Assertions.assertTrue(continueButton.isDisplayed());
        continueButton.click();

        // 16. Verify that 'Logged in as username' is visible
        WebElement loggedInText = driver.findElement(By.cssSelector(".navbar-nav li:nth-child(10) a"));
        Assertions.assertTrue(loggedInText.isDisplayed());
        Assertions.assertTrue(loggedInText.getText().contains(NAME));

        // 17. Click 'Delete Account' button
        WebElement deleteAccountButton = driver.findElement(By.cssSelector("a[href='/delete_account']"));
        Assertions.assertTrue(deleteAccountButton.isDisplayed());
        deleteAccountButton.click();

        // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDeletedText = driver.findElement(By.cssSelector("h2[data-qa='account-deleted'] b"));
        Assertions.assertTrue(accountDeletedText.isDisplayed());
        Assertions.assertEquals("ACCOUNT DELETED!", accountDeletedText.getText());

        WebElement finalContinueButton = driver.findElement(By.cssSelector("a[data-qa='continue-button']"));
        Assertions.assertTrue(finalContinueButton.isDisplayed());
        finalContinueButton.click();

        // Verify return to homepage
        WebElement finalHomePageSlider = driver.findElement(By.id("slider"));
        Assertions.assertTrue(finalHomePageSlider.isDisplayed());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}