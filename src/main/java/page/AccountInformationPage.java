package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountInformationPage {
    private final WebDriver driver;
    private final By enterAccountInfoText = By.cssSelector(".title b");
    private final By titleMr = By.id("id_gender1");
    private final By passwordInput = By.id("password");
    private final By dayDropdown = By.id("days");
    private final By monthDropdown = By.id("months");
    private final By yearDropdown = By.id("years");
    private final By newsletterCheckbox = By.id("newsletter");
    private final By offersCheckbox = By.id("optin");
    private final By firstNameInput = By.id("first_name");
    private final By lastNameInput = By.id("last_name");
    private final By companyInput = By.id("company");
    private final By address1Input = By.id("address1");
    private final By address2Input = By.id("address2");
    private final By countryDropdown = By.id("country");
    private final By stateInput = By.id("state");
    private final By cityInput = By.id("city");
    private final By zipcodeInput = By.id("zipcode");
    private final By mobileNumberInput = By.id("mobile_number");
    private final By createAccountButton = By.cssSelector("button[data-qa='create-account']");

    public AccountInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isEnterAccountInfoVisible() {
        return driver.findElement(enterAccountInfoText).isDisplayed();
    }

    public String getEnterAccountInfoText() {
        return driver.findElement(enterAccountInfoText).getText();
    }

    public void selectTitleMr() {
        driver.findElement(titleMr).click();
    }

    public boolean isTitleMrSelected() {
        return driver.findElement(titleMr).isSelected();
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public String getPasswordInputValue() {
        return driver.findElement(passwordInput).getAttribute("value");
    }

    public void selectDateOfBirth(String day, String month, String year) {
        new Select(driver.findElement(dayDropdown)).selectByValue(day);
        new Select(driver.findElement(monthDropdown)).selectByValue(month);
        new Select(driver.findElement(yearDropdown)).selectByValue(year);
    }

    public String getSelectedDayValue() {
        return new Select(driver.findElement(dayDropdown)).getFirstSelectedOption().getAttribute("value");
    }

    public String getSelectedMonthValue() {
        return new Select(driver.findElement(monthDropdown)).getFirstSelectedOption().getAttribute("value");
    }

    public String getSelectedYearValue() {
        return new Select(driver.findElement(yearDropdown)).getFirstSelectedOption().getAttribute("value");
    }

    public void selectNewsletterCheckbox() {
        driver.findElement(newsletterCheckbox).click();
    }

    public boolean isNewsletterCheckboxSelected() {
        return driver.findElement(newsletterCheckbox).isSelected();
    }

    public void selectOffersCheckbox() {
        driver.findElement(offersCheckbox).click();
    }

    public boolean isOffersCheckboxSelected() {
        return driver.findElement(offersCheckbox).isSelected();
    }

    public void fillPersonalDetails(String firstName, String lastName, String company,
                                    String address1, String address2, String country,
                                    String state, String city, String zipcode, String mobileNumber) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(companyInput).sendKeys(company);
        driver.findElement(address1Input).sendKeys(address1);
        driver.findElement(address2Input).sendKeys(address2);
        new Select(driver.findElement(countryDropdown)).selectByVisibleText(country);
        driver.findElement(stateInput).sendKeys(state);
        driver.findElement(cityInput).sendKeys(city);
        driver.findElement(zipcodeInput).sendKeys(zipcode);
        driver.findElement(mobileNumberInput).sendKeys(mobileNumber);
    }

    public String getFirstNameInputValue() {
        return driver.findElement(firstNameInput).getAttribute("value");
    }

    public String getLastNameInputValue() {
        return driver.findElement(lastNameInput).getAttribute("value");
    }

    public String getCompanyInputValue() {
        return driver.findElement(companyInput).getAttribute("value");
    }

    public String getAddress1InputValue() {
        return driver.findElement(address1Input).getAttribute("value");
    }

    public String getAddress2InputValue() {
        return driver.findElement(address2Input).getAttribute("value");
    }

    public String getSelectedCountryValue() {
        return new Select(driver.findElement(countryDropdown)).getFirstSelectedOption().getText();
    }

    public String getStateInputValue() {
        return driver.findElement(stateInput).getAttribute("value");
    }

    public String getCityInputValue() {
        return driver.findElement(cityInput).getAttribute("value");
    }

    public String getZipcodeInputValue() {
        return driver.findElement(zipcodeInput).getAttribute("value");
    }

    public String getMobileNumberInputValue() {
        return driver.findElement(mobileNumberInput).getAttribute("value");
    }

    public void clickCreateAccountButton() {
        driver.findElement(createAccountButton).click();
    }
}