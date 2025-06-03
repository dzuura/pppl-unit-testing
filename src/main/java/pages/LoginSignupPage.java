package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSignupPage {
    private final WebDriver driver;
    private final By newUserSignupText = By.cssSelector(".signup-form h2");
    private final By nameInput = By.name("name");
    private final By emailInput = By.cssSelector("input[data-qa='signup-email']");
    private final By signupButton = By.cssSelector("button[data-qa='signup-button']");

    public LoginSignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isNewUserSignupVisible() {
        return driver.findElement(newUserSignupText).isDisplayed();
    }

    public String getNewUserSignupText() {
        return driver.findElement(newUserSignupText).getText();
    }

    public void enterNameAndEmail(String name, String email) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
    }

    public String getNameInputValue() {
        return driver.findElement(nameInput).getAttribute("value");
    }

    public String getEmailInputValue() {
        return driver.findElement(emailInput).getAttribute("value");
    }

    public void clickSignupButton() {
        driver.findElement(signupButton).click();
    }
}