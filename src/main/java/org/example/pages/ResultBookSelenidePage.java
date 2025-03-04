package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class ResultBookSelenidePage {

    public int sizeOfbooksfilteredByKindle(){
        ElementsCollection elementsOfTheSearchfilteredByKindle = $$x("//div[@class='puisg-col-inner']//div//div//a[@class='a-size-base a-link-normal s-underline-text s-underline-link-text s-link-style a-text-bold' and (contains(text(),'Kindle') or contains(text(),'Paperback'))]");
        elementsOfTheSearchfilteredByKindle.get(0).should(clickable);
        return elementsOfTheSearchfilteredByKindle.size();
    }

    public int sizeOfbooksOptionsDiv(){
        ElementsCollection elementsOfTheFirstSearch = $$x("//span[contains(text(),'Thinking in Java')]");
        elementsOfTheFirstSearch.get(0).should(clickable);
        return elementsOfTheFirstSearch.size();
    }

    public SelenideElement getDynamicElementFilter(String name) {
        return $(By.xpath("//span[contains(text(),'" + name + "')]"));
    }

    public void clickOnFilter(String nameOfFilter){
        getDynamicElementFilter(nameOfFilter).should(clickable);
        getDynamicElementFilter(nameOfFilter).click();
    }

    public void selectFirstBook(){
        $(By.xpath("//span[contains(text(),'Java Concurrency in Practice')]")).scrollIntoView(true).click();
    }

    public void selectSecondBook(){
        $(By.xpath("//span[contains(text(),'Java Coding Problems: Become an expert Java programmer by solving over 250 brand-new, modern, real-world problems')]")).scrollIntoView(true).click();
    }
}