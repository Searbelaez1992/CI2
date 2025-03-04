package org.example.Facade;

import org.example.pages.BookSearchPage;

public class BookSearchFacade {

    private BookSearchPage bookSearchPage;

    public BookSearchFacade(BookSearchPage bookSearchPage) {
        this.bookSearchPage = bookSearchPage;
    }

    public void SearchActions(String book) {
        bookSearchPage.enterBookInSearchBar(book);
        bookSearchPage.clickOnsearchButton();
    }
}
