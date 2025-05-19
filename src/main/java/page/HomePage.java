package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;
    private final By homePageSlider = By.id("slider");
    private final By signupLoginButton = By.cssSelector("a[href='/login']");
    private final By loggedInText = By.cssSelector(".navbar-nav li:nth-child(10) a");
    private final By deleteAccountButton = By.cssSelector("a[href='/delete_account']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHomePageVisible() {
        return driver.findElement(homePageSlider).isDisplayed();
    }

    public void clickSignupLoginButton() {
        driver.findElement(signupLoginButton).click();
    }

    public boolean isLoggedInVisible() {
        return driver.findElement(loggedInText).isDisplayed();
    }

    public String getLoggedInText() {
        return driver.findElement(loggedInText).getText();
    }

    public void clickDeleteAccountButton() {
        driver.findElement(deleteAccountButton).click();
    }
}
