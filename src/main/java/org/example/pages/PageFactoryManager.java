package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageFactoryManager {
    private static WebDriverWait wait;

    public static SignUpPage getSignUpPage(WebDriver driver) {
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        return new SignUpPage(driver ,wait);
    }

    public static LoginPage getLoginPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return new LoginPage(driver ,wait);
    }

    public static BookSearchPage getBookSearchPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return new BookSearchPage(driver ,wait);
    }

    public static ResultBooksPage getResultBooksPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return new ResultBooksPage(driver ,wait);
    }

    public static SummaryBookPage getSummaryBookPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return new SummaryBookPage(driver ,wait);
    }

    public static CartPage getCartPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return new CartPage(driver ,wait);
    }
}