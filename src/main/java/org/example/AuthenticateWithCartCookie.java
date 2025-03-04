package org.example;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AuthenticateWithCartCookie {

    public static void authenticateToWebApp(String guid) {

        //7. Open web application
        Configuration.baseUrl = "https://www.kruidvat.nl";
        open("/");

        //8. Authenticate to web application by adding "kvn-cart" cookie with “guid” value to the browser via UI
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Cookie kvnCartCookie = new Cookie("kvn-cart", guid);
        getWebDriver().manage().addCookie(kvnCartCookie);
        refresh();

        //9. Navigate to Cart page and verify that it contains expected product via UI
        open("/cart");
        $("#onetrust-accept-btn-handler").should(visible).click();
        $(By.xpath("//div[text()='Beurer FC 45 Gezichtsborstel']")).should(clickable);
    }
}