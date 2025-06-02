package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage {
    private final WebDriver driver;
    private final By accountCreatedText = By.cssSelector("h2[data-qa='account-created'] b");
    private final By continueButton = By.cssSelector("a[data-qa='continue-button']");

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAccountCreatedVisible() {
        return driver.findElement(accountCreatedText).isDisplayed();
    }

    public String getAccountCreatedText() {
        return driver.findElement(accountCreatedText).getText();
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}
