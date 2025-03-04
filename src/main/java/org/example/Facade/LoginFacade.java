package org.example.Facade;

import org.example.pages.LoginPage;

//The "LoginFacade" class is created, in which we implement the "Facade" pattern in which we implement a simplified
// interface to perform all the actions on the "Login" page.
public class LoginFacade {

    private LoginPage loginPage;

    public LoginFacade(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public void loginActions(String email, String password) {
        loginPage.clickLoginMenu();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }
}
