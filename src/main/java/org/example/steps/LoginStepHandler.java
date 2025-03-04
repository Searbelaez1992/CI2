package org.example.steps;

import org.example.pages.LoginPage;

//The "LoginStepHandler" class is created in which the "Chain of Responsibility" design pattern is implemented,
// which is responsible for managing the test steps as a sequence of operations performed on the "Login" page.
public class LoginStepHandler extends StepHandler {
    private final LoginPage loginPage;
    private final String email, password;

    public LoginStepHandler(LoginPage loginPage, String email, String password) {
        this.loginPage = loginPage;
        this.email = email;
        this.password = password;
    }

    @Override
    protected void execute() {
        loginPage.clickLoginMenu();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }
}