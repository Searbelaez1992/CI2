package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookSearchPage extends BasePage{
    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBar;

    @FindBy(id = "nav-search-submit-button")
    WebElement searchButton;

    public BookSearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver,wait);
        PageFactory.initElements(driver, this);
    }

    public void enterBookInSearchBar(String book){
        searchBar.sendKeys(book);
    }

    public void clickOnsearchButton(){
        searchButton.click();
    }
}
