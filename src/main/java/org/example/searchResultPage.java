package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class searchResultPage {
    WebDriver driver;

    public searchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitlePage() {
        return driver.getTitle();
    }

    public String getLink(String querry) {
        By Link = By.partialLinkText(querry);
        return driver.findElement(Link).getText();
    }
}
