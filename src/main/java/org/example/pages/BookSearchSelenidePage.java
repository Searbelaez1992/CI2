package org.example.pages;

import static com.codeborne.selenide.Selenide.$;

public class BookSearchSelenidePage {
    public void enterBookInSearchBar(String book){
        $("#twotabsearchtextbox").sendKeys(book);
    }

    public void clickOnsearchButton(){
        $("#nav-search-submit-button").click();
    }
}