package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDeletedPage {
    private final WebDriver driver;
    private final By accountDeletedText = By.cssSelector("h2[data-qa='account-deleted'] b");
    private final By continueButton = By.cssSelector("a[data-qa='continue-button']");

    public AccountDeletedPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAccountDeletedVisible() {
        return driver.findElement(accountDeletedText).isDisplayed();
    }

    public String getAccountDeletedText() {
        return driver.findElement(accountDeletedText).getText();
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}