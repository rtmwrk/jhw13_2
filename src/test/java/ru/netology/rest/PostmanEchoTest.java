package ru.netology.rest;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTest {

    @Test
    void shouldPostmanEchoTest() {
        // Given - When - Then
        String userData = "{\"id\":1,\"name\":\"Elias\",\"job\":\"Engineer\"}";

        given()
                .baseUri("https://postman-echo.com")
                .body(userData)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(userData));
    }
}
