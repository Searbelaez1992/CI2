package org.example.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CartPage extends BasePage{

    @FindBy(xpath = "//h1[contains(text(),'Added to cart')]")
    WebElement addedToTheCartText;

    @FindBy(xpath = "//div[@class='a-section a-spacing-mini sc-list-body sc-java-remote-feature']//child::div[@data-bundleitem='absent']")
    List<WebElement> elementsOfTheCart;

    @FindBy(xpath = "//span[@id='sw-gtc']//span//a[contains(text(),'Go to Cart') and @class='a-button-text']")
    WebElement goToTheCartButton;

    @FindBy(name = "proceedToRetailCheckout")
    WebElement checkoutButton;

    @FindBy(xpath = "//span[@class='a-icon a-icon-small-add']")
    List<WebElement> elementsToAddTheAmountOfTheBooks;

    @FindBy(xpath = "//span[@class='a-spinner a-spinner-small']//following-sibling::span")
    List<WebElement> elementsNumberOfTheBooks;

    @FindBy(xpath = "//span[@class='a-icon a-icon-small-remove']")
    List<WebElement> elementsToDeleteTheBooks;

    @FindBy(id = "ap_email")
    WebElement emailButton;


    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
        PageFactory.initElements(driver, this);
    }

    public boolean verifytheTextIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(addedToTheCartText));
        return addedToTheCartText.isDisplayed();
    }

    public void clickOnCheckoutButton(){
        checkoutButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(emailButton));
    }

    public void clickOngoToTheCartButton(){
        wait.until(ExpectedConditions.elementToBeClickable(goToTheCartButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", goToTheCartButton);
    }

    public int sizeOfelementsOfTheCart(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return elementsOfTheCart.size();
    }

    public void clickOnelementsToAddTheAmountOfTheBooks(int elementNumber){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(elementsToAddTheAmountOfTheBooks.get(elementNumber)));

        elementsToAddTheAmountOfTheBooks.get(elementNumber).click();
    }

    public void clickOnelementsToDeleteTheBooks(int elementNumber){
        wait.until(ExpectedConditions.visibilityOf(elementsToDeleteTheBooks.get(elementNumber)));
        elementsToDeleteTheBooks.get(elementNumber).click();
    }
}
