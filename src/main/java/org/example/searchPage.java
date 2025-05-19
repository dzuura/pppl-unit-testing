package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class searchPage {
    WebDriver driver;

    public searchPage(WebDriver driver) {
        this.driver = driver;
    }

    //locator yang diperlukan dan interaksi yang digunakan
    By searchBar = By.id("sb_form_q");
    By searchForm = By.id("sb_form");

    public void setSearchBar(String querry) {
        driver.findElement(searchBar).sendKeys(querry);
    }

    public void submitForm() {
        driver.findElement(searchForm).submit();
    }

}
