import com.codeborne.selenide.ElementsCollection;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.example.api.CartService;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.given;
import static org.example.AuthenticateWithCartCookie.authenticateToWebApp;
import static org.hamcrest.Matchers.is;

public class CartApiTest {

    @Test
    public void addAproductToTheCart(){

        Map<String, Object> sessionStorage = new HashMap<>();

        CartService cartService = new CartService(sessionStorage);

        cartService.createCart();

        cartService.addProductToCart();

        String guid = (String) sessionStorage.get("guid");

        authenticateToWebApp(guid);
    }
}