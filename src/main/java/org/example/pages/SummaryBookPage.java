package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryBookPage extends BasePage{

    public SummaryBookPage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add-to-cart-button")
    WebElement addToTheCartButton;

    public void clickOnaddToTheCartButton(){
        wait.until(ExpectedConditions.elementToBeClickable(addToTheCartButton));
        addToTheCartButton.click();
    }
}
