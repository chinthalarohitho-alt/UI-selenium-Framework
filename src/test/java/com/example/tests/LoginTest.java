package com.example.tests;

import com.example.pages.LoginPage;
import com.example.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        // create a fresh driver per test to avoid shared state and enable parallelism
        driver = WebDriverFactory.createDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        String baseUrl = System.getProperty("baseUrl", "https://example.com/login");
        String username = System.getProperty("username", "testuser");
        String password = System.getProperty("password", "testpassword");

        loginPage.open(baseUrl);

        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.submit();

        // Wait for a stable post-login condition (adjust timeout and predicate as needed).
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        boolean loggedIn = wait.until(d -> {
            try {
                return loginPage.isLoggedIn();
            } catch (Exception e) {
                return false;
            }
        });

        Assert.assertTrue(loggedIn, "User should be logged in");
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception ignored) {
                // ignore errors on quit
            }
        }
    }
}
