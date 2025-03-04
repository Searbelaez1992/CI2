package org.example.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.clickable;

public class SummaryBookSelenidePage {

    public void clickOnaddToTheCartButton(){
        $("#add-to-cart-button").should(clickable);
        $("#add-to-cart-button").click();
    }
}