package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ResultBooksPage extends BasePage{
    @FindBy(xpath = "//span[contains(text(),'Thinking in Java')]")
    List<WebElement> elementsOfTheFirstSearch;

    @FindBy(xpath = "//div[@class= 'aok-relative']/span[@class= 'rush-component']")
    List<WebElement> elementsOfTheSearch;

    @FindBy(xpath = "//div[@class='puisg-col-inner']//div//div//a[@class='a-size-base a-link-normal s-underline-text s-underline-link-text s-link-style a-text-bold' and (contains(text(),'Kindle') or contains(text(),'Paperback'))]")
    List<WebElement> elementsOfTheSearchfilteredByKindle;

    @FindBy(xpath = "//span[contains(text(),'Java Concurrency in Practice')]")
    WebElement firstBookToSelect;

    @FindBy(xpath = "//span[contains(text(),'Java Coding Problems: Become an expert Java programmer by solving over 250 brand-new, modern, real-world problems')]")
    WebElement SecondBookToSelect;

    public ResultBooksPage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
        PageFactory.initElements(driver, this);
    }

    public int sizeOfbooksfilteredByKindle(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return elementsOfTheSearchfilteredByKindle.size();
    }

    public int sizeOfbooksOptionsDiv(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return elementsOfTheFirstSearch.size();
    }

    public WebElement getDynamicElementFilter(String name) {
        return driver.findElement(By.xpath("//span[contains(text(),'" + name + "')]"));
    }

    public void clickOnFilter(String nameOfFilter){
        wait.until(ExpectedConditions.elementToBeClickable(getDynamicElementFilter(nameOfFilter)));
        getDynamicElementFilter(nameOfFilter).click();
    }

    public void selectFirstBook(){
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        actions.moveToElement(firstBookToSelect);
        actions.click(firstBookToSelect);
        actions.perform();
    }

    public void selectSecondBook(){
        Actions actions = new Actions(driver);
        actions.moveToElement(SecondBookToSelect);
        actions.click(SecondBookToSelect);
        actions.perform();
    }
}
