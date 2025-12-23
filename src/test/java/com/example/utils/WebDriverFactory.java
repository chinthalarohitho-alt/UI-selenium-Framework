package com.example.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    public static WebDriver createDriver() {
        String browser = System.getProperty("browser", "chrome").toLowerCase();

        switch (browser) {
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                String headless = System.getProperty("headless", "true");
                if (Boolean.parseBoolean(headless)) {
                    options.addArguments("--headless=new");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--window-size=1920,1080");
                }
                return new ChromeDriver(options);
        }
    }
}