package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
public class LoginPageSelenide {

    public void clickLoginMenu(){
        SelenideElement loginMenu = $(By.xpath("//li/a[text() = 'Login']"));
        loginMenu.should(be(visible));
        loginMenu.click();
    }

    public void enterEmail(String emailUSer){
        $(By.name("email")).sendKeys(emailUSer);
    }

    public void enterPassword(String passwordUSer){
        $(By.name("password")).sendKeys(passwordUSer);
    }

    public void clickLoginButton(){
        $(By.xpath("//button[contains(text(),'Login')]")).click();
    }

    public SelenideElement getDynamicElement(String name) {
        return $(By.xpath("//li/div[text()= '" + name + "']"));
    }

    public String getNameUser(String nameUser){
        getDynamicElement(nameUser).should(be(visible));
        return getDynamicElement(nameUser).getText();
    }

    public String getMessageError(){
        SelenideElement errorMessage = $(By.xpath("//ul[@class='error-messages']/li"));
        errorMessage.should(be(visible));
        return errorMessage.getText();
    }
}