package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class CartSelenidePage {

    public void clickOnCheckoutButton(){
        $(By.name("proceedToRetailCheckout")).should(clickable);
        $(By.name("proceedToRetailCheckout")).click();
        $("#ap_email").should(clickable);
    }

    public void clickOngoToTheCartButton(){
        $(By.xpath("//span[@id='sw-gtc']//span//a[contains(text(),'Go to Cart') and @class='a-button-text']")).should(clickable);
        $(By.xpath("//span[@id='sw-gtc']//span//a[contains(text(),'Go to Cart') and @class='a-button-text']")).click();
    }

    public int sizeOfelementsOfTheCart(){
        ElementsCollection elementsOfTheCart = $$x("//div[@class='a-section a-spacing-mini sc-list-body sc-java-remote-feature']//child::div[@data-bundleitem='absent']");
        elementsOfTheCart.get(0).should(clickable);
        return elementsOfTheCart.size();
    }

    public void clickOnelementsToAddTheAmountOfTheBooks(int elementNumber){
        ElementsCollection elementsToAddTheAmountOfTheBooks = $$x("//span[@class='a-icon a-icon-small-add']");
        elementsToAddTheAmountOfTheBooks.get(0).should(clickable);
        elementsToAddTheAmountOfTheBooks.get(elementNumber).click();
    }

    public void clickOnelementsToDeleteTheBooks(int elementNumber){
        ElementsCollection elementsToDeleteTheBooks = $$x("//span[@class='a-icon a-icon-small-remove']");
        elementsToDeleteTheBooks.get(0).should(clickable);
        elementsToDeleteTheBooks.get(elementNumber).click();
    }

    public void addAmountOfTheBook(int numberOfTheBook, int numberOfAmount){
        for(int i = 0;i <  numberOfAmount; i++){
            clickOnelementsToAddTheAmountOfTheBooks(numberOfTheBook);
            try {
                Thread.sleep( 1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void deleteTheBook(int numberOfTheBook,int numberOfAmount){
        for(int i = 0;i <  numberOfAmount; i++){
            clickOnelementsToDeleteTheBooks(numberOfTheBook);
            try {
                Thread.sleep( 1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        $(By.xpath("//span[@class='a-icon a-icon-small-trash']")).should(clickable);
        $(By.xpath("//span[@class='a-icon a-icon-small-trash']")).click();
    }
}