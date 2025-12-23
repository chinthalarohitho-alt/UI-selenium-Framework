package com.example.tests;

import com.example.pages.LoginPage;
import com.example.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setup() {
        driver = WebDriverFactory.createDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        String baseUrl = System.getProperty("baseUrl", "https://example.com/login");
        loginPage.open(baseUrl);

        // Example credentials - replace with valid test credentials or test doubles
        loginPage.setUsername("testuser");
        loginPage.setPassword("testpassword");
        loginPage.submit();

        // Replace with an assert appropriate to your app
        Assert.assertTrue(loginPage.isLoggedIn(), "User should be logged in");
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}