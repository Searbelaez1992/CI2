package org.example.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//The "WebDriverSingleton" class is created in which the "Singleton" design pattern is implemented for managing the "WebDriver".
// This ensures that the WebDriver instance is shared throughout the application.
public class WebDriverSingleton {

    private static WebDriver driver;
    private WebDriverSingleton() {}

    public static WebDriver getInstance() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }
}
