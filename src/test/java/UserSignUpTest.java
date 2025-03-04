import com.codeborne.selenide.junit5.ScreenShooterExtension;
import managers.FileReaderManager;
import org.example.dto.UserDTO;
import org.example.pages.SignUpSelenidePage;
import org.junit.Assert;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.testng.annotations.*;
import static com.codeborne.selenide.Selenide.*;

//@ExtendWith({ScreenShooterExtension.class})
public class UserSignUpTest {

    @RegisterExtension
    static ScreenShooterExtension extension = new ScreenShooterExtension().to("target/selenide");

    @BeforeMethod
    public void setUp() {
        open("https://conduit-realworld-example-app.fly.dev/");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{"Jose Daniel"}, {"Maria"}};
    }


    @Test (dataProvider = "data-provider")
    public void successfulSigUp(String nameLoginUser) {
        UserDTO user = FileReaderManager.getInstance().getJsonReader().getUserByName(nameLoginUser);
        int uniqueId = (int) (Math.random() * 1000);
        String username = user.getName() + uniqueId;
        String email = user.getEmail().replace("@", "." + uniqueId + "@");
        user.setName(username);
        user.setEmail(email);

        SignUpSelenidePage signUpSelenidePage = new SignUpSelenidePage();

        signUpSelenidePage.clickLoginMenu();
        signUpSelenidePage.enterName(user.getName());
        signUpSelenidePage.enterEmail(user.getEmail());
        signUpSelenidePage.enterPassword(user.getPassword());
        signUpSelenidePage.clicksignUpButton();
        Assert.assertEquals(user.getName(), signUpSelenidePage.getNameUser(user.getName()));
        screenshot("User successfull SigUp with email = " +user.getEmail() + " and name = " + user.getName());
    }
    
    @Test (dataProvider = "data-provider")
    public void ErrorPasswordMessage(String nameLoginUser) {
        UserDTO user = FileReaderManager.getInstance().getJsonReader().getUserByName(nameLoginUser);

        SignUpSelenidePage signUpSelenidePage = new SignUpSelenidePage();

        signUpSelenidePage.clickLoginMenu();
        signUpSelenidePage.enterName(user.getName());
        signUpSelenidePage.enterEmail(user.getEmail());
        signUpSelenidePage.enterPassword(user.getPassword());
        signUpSelenidePage.clicksignUpButton();
        Assert.assertEquals(signUpSelenidePage.getMessageError(), "Email already exists.. try logging in");
        screenshot("User Error Password Message SigUp with email = " +user.getEmail() + " and name = " + user.getName());
    }

    @AfterMethod
    public void terminate() {
        closeWebDriver();;
    }
}