package org.example.strategy;

import org.example.pages.LoginPage;

//The Strategy Pattern is implemented in the strategy package with the "ExecutionStrategy" interface.
//We have this class that implements the "ExecutionStrategy" interface to override the "login" method and here
// use the methods created by means of "PageObject
public class PageFactoryExecutionStrategy implements ExecutionStrategy {
    private final LoginPage loginPage;

    public PageFactoryExecutionStrategy(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @Override
    public void login(String email, String password) {
        loginPage.clickLoginMenu();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }
}
