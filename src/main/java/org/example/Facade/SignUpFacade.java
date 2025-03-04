package org.example.Facade;

import org.example.pages.SignUpPage;

//The "SignUpFacade" class is created, in which we implement the "Facade" pattern in which we implement a simplified
// interface to perform all the actions on the "SignUp" page.
public class SignUpFacade {

    private SignUpPage signUpPage;

    public SignUpFacade(SignUpPage signUpPage) {
        this.signUpPage = signUpPage;
    }

    public void signUpActions(String name,String email, String password) {
        signUpPage.clickLoginMenu();
        signUpPage.enterName(name);
        signUpPage.enterEmail(email);
        signUpPage.enterPassword(password);
        signUpPage.clicksignUpButton();
    }
}
