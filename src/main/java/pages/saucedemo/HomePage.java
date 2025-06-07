package pages.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By productTitle = By.className("title"); // elemen dengan teks "Products"

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Untuk memverifikasi halaman login berhasil
    public String getTextProducts() {
        return driver.findElement(productTitle).getText();
    }

    // Untuk validasi URL aktual
    public String getActualUrl() {
        return driver.getCurrentUrl();
    }
}
