package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

//The "LoginPage" class is created in which "Page objec" design pattern is implemented. Here the elements of the
// "Login" page and their interactions are encapsulated.
//The "LoginPage" class is created in which the "Page Factory" design pattern is implemented with which the
// initialization of the page elements is performed.

public class LoginPage extends BasePage {
    @FindBy(xpath = "//li/a[text() = 'Login']")
    WebElement loginMenu;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginButton;

    @FindBy(xpath = "//ul[@class='error-messages']/li")
    WebElement errorMessage;

    protected WebDriverWait wait;

    public WebElement getDynamicElement(String name) {
        return driver.findElement(By.xpath("//li/div[text()= '" + name + "']"));
    }

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
        PageFactory.initElements(driver, this);
    }

    public void clickLoginMenu(){
        loginMenu.click();
    }

    public void enterEmail(String emailUSer){
        email.sendKeys(emailUSer);
    }

    public void enterPassword(String passwordUSer){
        password.sendKeys(passwordUSer);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public String getNameUser(String nameUser){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return getDynamicElement(nameUser).getText();
    }

    public String getMessageError(){
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        return errorMessage.getText();
    }
}