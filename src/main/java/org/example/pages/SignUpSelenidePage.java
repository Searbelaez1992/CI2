package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SignUpSelenidePage {
    public void clickLoginMenu(){
        SelenideElement signupMenu = $(By.xpath("//li/a[text() = 'Sign up']"));
        signupMenu.should(be(visible));
        signupMenu.click();
    }

    public void enterName(String userName){
        $(By.name("username")).sendKeys(userName);
    }
    public void enterEmail(String emailUSer){
        $(By.name("email")).sendKeys(emailUSer);
    }

    public void enterPassword(String passwordUSer){
        $(By.name("password")).sendKeys(passwordUSer);
    }

    public void clicksignUpButton(){
        $(By.xpath("//button[contains(text(),'Sign up')]")).click();
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