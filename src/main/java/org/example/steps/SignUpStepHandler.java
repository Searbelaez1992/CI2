package org.example.steps;

import org.example.pages.SignUpPage;

//The "SignUpStepHandler" class is created in which the "Chain of Responsibility" design pattern is implemented,
// which is responsible for managing the test steps as a sequence of operations performed on the "SignUp" page.
public class SignUpStepHandler extends StepHandler {
    private final SignUpPage signUpPage;
    private final String email, name, password;

    public SignUpStepHandler(SignUpPage signUpPage, String email, String name, String password) {
        this.signUpPage = signUpPage;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    @Override
    protected void execute() {
        signUpPage.clickLoginMenu();
        signUpPage.enterName(name);
        signUpPage.enterEmail(email);
        signUpPage.enterPassword(password);
        signUpPage.clicksignUpButton();
    }
}