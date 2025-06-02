import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.*;

public class RegisterPOMTest {
    private WebDriver driver;
    private final String BASE_URL = "https://automationexercise.com/";
    private final String NAME = "Test User";
    private final String EMAIL = "testuser700@gmail.com";
    private final String PASSWORD = "password123";

    @BeforeEach
    public void setUp() {
        driver = new EdgeDriver();
        Assertions.assertNotNull(driver);
    }

    @Test
    public void testUserRegistration() {
        // Initialize page objects
        HomePage homePage = new HomePage(driver);
        LoginSignupPage loginSignupPage = new LoginSignupPage(driver);
        AccountInformationPage accountInformationPage = new AccountInformationPage(driver);
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        AccountDeletedPage accountDeletedPage = new AccountDeletedPage(driver);

        // 2. Navigate to url
        driver.get(BASE_URL);
        Assertions.assertEquals(BASE_URL, driver.getCurrentUrl());

        // 3. Verify that home page is visible successfully
        Assertions.assertTrue(homePage.isHomePageVisible());

        // 4. Click on 'Signup / Login' button
        homePage.clickSignupLoginButton();
        Assertions.assertTrue(driver.getCurrentUrl().contains("login"));

        // 5. Verify 'New User Signup!' is visible
        Assertions.assertTrue(loginSignupPage.isNewUserSignupVisible());
        Assertions.assertEquals("New User Signup!", loginSignupPage.getNewUserSignupText());

        // 6. Enter name and email address
        loginSignupPage.enterNameAndEmail(NAME, EMAIL);
        Assertions.assertEquals(NAME, loginSignupPage.getNameInputValue());
        Assertions.assertEquals(EMAIL, loginSignupPage.getEmailInputValue());

        // 7. Click 'Signup' button
        loginSignupPage.clickSignupButton();

        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assertions.assertTrue(accountInformationPage.isEnterAccountInfoVisible());
        Assertions.assertEquals("ENTER ACCOUNT INFORMATION", accountInformationPage.getEnterAccountInfoText());

        // 9. Fill details: Title, Name, Email, Password, Date of birth
        accountInformationPage.selectTitleMr();
        Assertions.assertTrue(accountInformationPage.isTitleMrSelected());

        accountInformationPage.enterPassword(PASSWORD);
        Assertions.assertEquals(PASSWORD, accountInformationPage.getPasswordInputValue());

        accountInformationPage.selectDateOfBirth("15", "6", "1990");
        Assertions.assertEquals("15", accountInformationPage.getSelectedDayValue());
        Assertions.assertEquals("6", accountInformationPage.getSelectedMonthValue());
        Assertions.assertEquals("1990", accountInformationPage.getSelectedYearValue());

        // 10. Select checkbox 'Sign up for our newsletter!'
        accountInformationPage.selectNewsletterCheckbox();
        Assertions.assertTrue(accountInformationPage.isNewsletterCheckboxSelected());

        // 11. Select checkbox 'Receive special offers from our partners!'
        accountInformationPage.selectOffersCheckbox();
        Assertions.assertTrue(accountInformationPage.isOffersCheckboxSelected());

        // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        accountInformationPage.fillPersonalDetails(
                "Test", "User", "Test Company", "Test Address", "Test Street",
                "United States", "California", "San Francisco", "94105", "1234567890"
        );
        Assertions.assertEquals("Test", accountInformationPage.getFirstNameInputValue());
        Assertions.assertEquals("User", accountInformationPage.getLastNameInputValue());
        Assertions.assertEquals("Test Company", accountInformationPage.getCompanyInputValue());
        Assertions.assertEquals("Test Address", accountInformationPage.getAddress1InputValue());
        Assertions.assertEquals("Test Street", accountInformationPage.getAddress2InputValue());
        Assertions.assertEquals("United States", accountInformationPage.getSelectedCountryValue());
        Assertions.assertEquals("California", accountInformationPage.getStateInputValue());
        Assertions.assertEquals("San Francisco", accountInformationPage.getCityInputValue());
        Assertions.assertEquals("94105", accountInformationPage.getZipcodeInputValue());
        Assertions.assertEquals("1234567890", accountInformationPage.getMobileNumberInputValue());

        // 13. Click 'Create Account button'
        accountInformationPage.clickCreateAccountButton();

        // 14. Verify that 'ACCOUNT CREATED!' is visible
        Assertions.assertTrue(accountCreatedPage.isAccountCreatedVisible());
        Assertions.assertEquals("ACCOUNT CREATED!", accountCreatedPage.getAccountCreatedText());

        // 15. Click 'Continue' button
        accountCreatedPage.clickContinueButton();

        // 16. Verify that 'Logged in as username' is visible
        Assertions.assertTrue(homePage.isLoggedInVisible());
        Assertions.assertTrue(homePage.getLoggedInText().contains(NAME));

        // 17. Click 'Delete Account' button
        homePage.clickDeleteAccountButton();

        // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assertions.assertTrue(accountDeletedPage.isAccountDeletedVisible());
        Assertions.assertEquals("ACCOUNT DELETED!", accountDeletedPage.getAccountDeletedText());
        accountDeletedPage.clickContinueButton();

        // Verify return to homepage
        Assertions.assertTrue(homePage.isHomePageVisible());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}