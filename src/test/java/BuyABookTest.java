import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.example.pages.*;
import org.example.utils.WebDriverSingleton;
import org.junit.Assert;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class BuyABookTest {

    @RegisterExtension
    static ScreenShooterExtension extension = new ScreenShooterExtension().to("target/selenide");

    @BeforeMethod
    public void setUp() {
        open("https://www.bookdepository.com/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @Test
    public void buyABook(){

        BookSearchSelenidePage bookSearchSelenidePage = new BookSearchSelenidePage();
        bookSearchSelenidePage.enterBookInSearchBar("Thinking in Java");
        bookSearchSelenidePage.clickOnsearchButton();

        ResultBookSelenidePage resultBookSelenidePage = new ResultBookSelenidePage();
        int numberOfBooksSearchedOriginaly = resultBookSelenidePage.sizeOfbooksOptionsDiv();
        Assert.assertTrue("The search results contain different books",numberOfBooksSearchedOriginaly > 4);

        resultBookSelenidePage.clickOnFilter("Kindle Edition");
        int numberOfBooksfilteredByKindle = resultBookSelenidePage.sizeOfbooksfilteredByKindle();
        Assert.assertTrue("Verify that only books with Paperback format available are displayed",numberOfBooksfilteredByKindle >= numberOfBooksSearchedOriginaly);

        resultBookSelenidePage.clickOnFilter("Kindle Edition");
        resultBookSelenidePage.selectFirstBook();

        SummaryBookSelenidePage summaryBookSelenidePage = new SummaryBookSelenidePage();
        summaryBookSelenidePage.clickOnaddToTheCartButton();

        bookSearchSelenidePage.enterBookInSearchBar("Thinking in Java");
        bookSearchSelenidePage.clickOnsearchButton();

        resultBookSelenidePage.selectSecondBook();
        summaryBookSelenidePage.clickOnaddToTheCartButton();

        CartSelenidePage cartSelenidePage = new CartSelenidePage();
        cartSelenidePage.clickOngoToTheCartButton();

        int numberOfBooksfonTheCart = cartSelenidePage.sizeOfelementsOfTheCart();
        Assert.assertTrue("Verify that are 2 books",numberOfBooksfonTheCart == 2);

        int amountFirstBook = (int) (Math.random() * 7);
        int amountSecondBook = (int) (Math.random() * 7);

        cartSelenidePage.addAmountOfTheBook(0,amountFirstBook);
        cartSelenidePage.addAmountOfTheBook(1,amountSecondBook);

        cartSelenidePage.deleteTheBook(0,amountFirstBook);

        cartSelenidePage.clickOnCheckoutButton();

        Assert.assertTrue("Verify login/sign up page is displayed", Selenide.title().equals("Amazon Sign-In"));
        screenshot("login/sign up page");
    }

    @AfterMethod
    public void terminate() {
        closeWebDriver();
    }
}
