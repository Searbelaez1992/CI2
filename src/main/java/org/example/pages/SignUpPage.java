package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

//The "SignUpPage" class is created in which "Page objec" design pattern is implemented. Here the elements of the
// "SignUp" page and their interactions are encapsulated.
//The "SignUpPage" class is created in which the "Page Factory" design pattern is implemented with which the
// initialization of the page elements is performed.
public class SignUpPage extends BasePage {

    @FindBy(xpath = "//li/a[text() = 'Sign up']")
    WebElement signupMenu;

    @FindBy(name = "username")
    WebElement name;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Sign up')]")
    WebElement signUpButton;

    @FindBy(xpath = "//ul[@class='error-messages']/li")
    WebElement errorMessage;

    public WebElement getDynamicElement(String name) {
        return driver.findElement(By.xpath("//li/div[text()= '" + name + "']"));
    }

    public SignUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
        PageFactory.initElements(driver, this);
    }

    public void clickLoginMenu(){
        signupMenu.click();
    }
    public void enterName(String userName){
        name.sendKeys(userName);
    }
    public void enterEmail(String emailUSer){
        email.sendKeys(emailUSer);
    }

    public void enterPassword(String passwordUSer){
        password.sendKeys(passwordUSer);
    }

    public void clicksignUpButton(){
        signUpButton.click();
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