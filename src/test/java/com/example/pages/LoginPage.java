package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final By username = By.id("username");
    private final By password = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void setUsername(String user) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
    }

    public void setPassword(String pass) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }

    public void submit() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoggedIn() {
        // Example: check for existence of a logout button or user profile element
        return driver.findElements(By.cssSelector(".logout, .profile")).size() > 0;
    }
}