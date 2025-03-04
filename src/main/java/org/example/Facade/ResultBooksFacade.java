package org.example.Facade;

import org.example.pages.ResultBooksPage;

public class ResultBooksFacade {

    private ResultBooksPage resultBooksPage;

    public ResultBooksFacade(ResultBooksPage resultBooksPage) {
        this.resultBooksPage = resultBooksPage;
    }

    public int NumberOfBooks(){
        return resultBooksPage.sizeOfbooksOptionsDiv();
    }

    public int NumberOfBooksfilteredByKindle(){
        return resultBooksPage.sizeOfbooksfilteredByKindle();
    }

    public void ApplysearchFilters(String filter){
        resultBooksPage.clickOnFilter(filter);
    }

    public void SelectABook(){
        resultBooksPage.selectFirstBook();
    }

    public void SelectASecondBook(){
        resultBooksPage.selectSecondBook();
    }
}
