import com.codeborne.selenide.junit5.ScreenShooterExtension;
import managers.FileReaderManager;
import org.example.dto.UserDTO;
import org.example.pages.LoginPageSelenide;
import org.junit.Assert;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;

public class UserLoginTest {

    @RegisterExtension
    static ScreenShooterExtension extension = new ScreenShooterExtension().to("target/selenide");

    @BeforeMethod
    public void setUp() {
        open("https://conduit-realworld-example-app.fly.dev/");
    }

    @DataProvider(name = "data-provider-succesful")
    public Object[][] dpMethodSucesfull(){
        return new Object[][] {{"John Doe"}, {"Maria"}};
    }

    @DataProvider(name = "data-provider-error")
    public Object[][] dpMethodError(){
        return new Object[][] {{"Lakshay"}, {"Miguel"}};
    }

    @Test (dataProvider = "data-provider-succesful")
    public void successfulSigUp(String nameLoginUser) {
        UserDTO user = FileReaderManager.getInstance().getJsonReader().getUserByName(nameLoginUser);

        LoginPageSelenide loginPageSelenide = new LoginPageSelenide();

        loginPageSelenide.clickLoginMenu();
        loginPageSelenide.enterEmail(user.getEmail());
        loginPageSelenide.enterPassword(user.getPassword());
        loginPageSelenide.clickLoginButton();
        Assert.assertEquals(user.getName(), loginPageSelenide.getNameUser(user.getName()));

        screenshot("User successfull Login with email = " +user.getEmail() + " and name = " + user.getName());
    }

    @Test  (dataProvider = "data-provider-error")
    public void ErrorPasswordMessage(String nameLoginUser) {

        UserDTO user = FileReaderManager.getInstance().getJsonReader().getUserByName(nameLoginUser);

        LoginPageSelenide loginPageSelenide = new LoginPageSelenide();

        loginPageSelenide.clickLoginMenu();
        loginPageSelenide.enterEmail(user.getEmail());
        loginPageSelenide.enterPassword(user.getPassword());
        loginPageSelenide.clickLoginButton();

        String nameError = loginPageSelenide.getMessageError();
        Assert.assertEquals(nameError, "Email not found sign in first");
        screenshot("User Error Password Message Login with email = " +user.getEmail() + " and name = " + user.getName());
    }

    @AfterMethod
    public void terminate() {
        closeWebDriver();
    }
}