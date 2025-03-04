package org.example.Facade;

import org.example.pages.SummaryBookPage;

public class SummaryBookFacade {

    private SummaryBookPage summaryBookPage;

    public SummaryBookFacade(SummaryBookPage summaryBookPage) {
        this.summaryBookPage = summaryBookPage;
    }

    public void AddTheBookToTheBasket(){
        summaryBookPage.clickOnaddToTheCartButton();
    }
}
