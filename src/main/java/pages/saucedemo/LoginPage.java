package pages.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Lokator elemen
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    // Konstruktor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method untuk input username
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    // Method untuk input password
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Method untuk klik tombol login
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}
