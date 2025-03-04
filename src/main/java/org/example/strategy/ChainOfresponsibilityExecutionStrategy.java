package org.example.strategy;

import org.example.pages.LoginPage;
import org.example.steps.LoginStepHandler;

//The Strategy Pattern is implemented in the strategy package with the "ExecutionStrategy" interface.
//We have this class that implements the "ExecutionStrategy" interface to override the "login" method
// and here use the methods created with "Chain of Responsibility"
public class ChainOfresponsibilityExecutionStrategy implements ExecutionStrategy {
    private final LoginPage loginPage;

    public ChainOfresponsibilityExecutionStrategy(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @Override
    public void login(String email, String password) {
        LoginStepHandler loginStep = new LoginStepHandler(loginPage, email, password);
        loginStep.handle();
    }
}