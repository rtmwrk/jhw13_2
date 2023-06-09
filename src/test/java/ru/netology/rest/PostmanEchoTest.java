package ru.netology.rest;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTest {

    // Тест поля "data" в ответе сервиса
    @Test
    void shouldPostmanEchoTest() {
        // Given - When - Then
        String userData = "{\"id\":1,\"name\":\"Elias\",\"job\":\"Engineer\"}";
        String userErrorData = "{\"id\":1,\"name\":\"Elias\",\"job\":\"Artist\"}";

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
