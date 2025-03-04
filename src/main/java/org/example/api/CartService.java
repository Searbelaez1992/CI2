package org.example.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.example.models.OrderRequest;
import org.example.models.Product;
import org.junit.Assert;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class CartService {

    private final Map<String, Object> sessionStorage;
    private static final String PAYLOAD_TEMPLATE = "{ \"product\": { \"code\": \"{{productCode}}\" }, \"quantity\": {{quantity}} }";

    public CartService(Map<String, Object> sessionStorage) {
        this.sessionStorage = sessionStorage;
    }

    public void createCart() {
        //1. Create initial setup, e.g. RestAssured.requestSpecification (if RestAssured was chosen) or Configuration.baseUrl (if Selenide was chosen for UI part)
        //2. Create cart via API - Parse the response and store to session storage the “guid” value
        RestAssured.baseURI = "https://www.kruidvat.nl";

        var response = given()
                .header("accept", "application/json")
                .header("accept-language", "en-US,en;q=0.9")
                .header("content-type", "application/json;charset=UTF-8")
                .header("user-agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36")
                .body("")
                .when()
                .post("/api/v2/kvn/users/anonymous/carts?lang=nl")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .extract()
                .response();

        String guid = response.jsonPath().getString("guid");

        System.out.println("guid = "+ guid);
        sessionStorage.put("guid", guid);
    }

    public void addProductToCart() {
        //3. Add product to cart via API

        RestAssured.baseURI = "https://www.kruidvat.nl/api/v2/kvn";

        String guid = (String) sessionStorage.get("guid");

        //3.1. for payload creation use model builder
        Product product = new Product("offer_21950");
        OrderRequest orderRequest = new OrderRequestBuilder()
                .setProduct(product)
                .setQuantity(1)
                .build();

        System.out.println("orderRequest ="+orderRequest);
        System.out.println("orderRequest  code="+orderRequest.getProduct().getCode());
        System.out.println("orderRequest quantity="+orderRequest.getQuantity());

        //3.2. for payload creation use template resolved with values

        String resolvedPayload = resolvePayload("offer_21950", 1);
        System.out.println("Resolved Payload: " + resolvedPayload);
        Gson gson = new Gson();
        OrderRequest jsonPayload = gson.fromJson(resolvedPayload, OrderRequest.class);
        System.out.println("JSON Object: " + gson.toJson(jsonPayload));

        //3.3. for payload creation use map with values and object mapper of your choice to convert map to POJO
        Map<String, Object> payload = new HashMap<>();

        Map<String, String> productMap = new HashMap<>();
        productMap.put("code", "offer_21950");
        payload.put("product", productMap);
        payload.put("quantity", 1);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            OrderRequest orderRequestforMap = objectMapper.convertValue(payload, OrderRequest.class);

            System.out.println("orderRequestforMap ="+orderRequestforMap.toString());
            System.out.println("orderRequest  code="+orderRequestforMap.getProduct().getCode());
            System.out.println("orderRequest quantity="+orderRequestforMap.getQuantity());
        } catch (Exception e) {
            e.printStackTrace();
        }

        String jsonBody = "{\"product\":{\"code\":\"offer_21950\"},\"quantity\":1}";
        System.out.println("jsonbody = "+jsonBody);


        var response = RestAssured.given()
                .header("accept", "application/json")
                .header("accept-language", "en-US,en;q=0.9")
                .header("content-type", "application/json;charset=UTF-8")
                .header("user-agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36")
                .body(jsonBody)
                .contentType(ContentType.JSON)
                .when()
                .post("/users/anonymous/carts/" + guid +"/entries")
                .then()
                .statusCode(200)
                .extract()
                .response();

        //4. Verify cart response has expected json schema
        File schemaFile = new File("src/test/resources/entry-schema.json");
        response.then().assertThat().body(matchesJsonSchema(schemaFile));

        //5. Verify cart response has expected quantity and product code
        Assert.assertEquals("Quantity",response.jsonPath().getString("quantity"),"1");
        Assert.assertEquals("product code",response.jsonPath().getString("entry.offerId"),"21950");

        //6. Verify the response headers6. Verify the response headers
        String contentType = response.header("Content-Type");
        String contentEncoding = response.header("Content-Encoding");
        Assert.assertEquals(contentType, "application/json;charset=UTF-8");
        Assert.assertEquals(contentEncoding, "gzip");
    }

    public static String resolvePayload(String productCode, int quantity) {
        Map<String, Object> values = new HashMap<>();
        values.put("productCode", productCode);
        values.put("quantity", quantity);

        return resolveTemplate(PAYLOAD_TEMPLATE, values);
    }

    private static String resolveTemplate(String template, Map<String, Object> values) {
        String resolved = template;
        for (Map.Entry<String, Object> entry : values.entrySet()) {
            resolved = resolved.replace("{{" + entry.getKey() + "}}", entry.getValue().toString());
        }
        return resolved;
    }
}