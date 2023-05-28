package ru.netology.rest;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTest {

    @Test
    void shouldPostmanEchoTest() {
        // Given - When - Then
        String requestBody = "{ \"command\": {\n" +
                "    \"firstName\": \"Ivan\",\n" +
                "    \"lastName\": \"Petrov\",\n" +
                "    \"age\": 26\n" +
                "  }\n" +
                "}";

        given()
                .baseUri("https://postman-echo.com")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("command.age", equalTo("26"));
    }
}
