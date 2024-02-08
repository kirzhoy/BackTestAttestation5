package org.kirzhoy.SpoonAcularTest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

public class ApiSearchTest {
    @BeforeAll
    static void beforeAll() {
        baseURI = "https://api.spoonacular.com";
      RestAssured.requestSpecification = new RequestSpecBuilder()
                .addParam("apiKey", "bb573bcaff9f47aabf2202cede5bb643")
                .build();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void pastaSearchTest() {
        given()
                .param("query", "pasta")
                .param("diet", "paleo")
                //.log().all()
                .expect()
                .statusCode(200)
                .time(Matchers.lessThanOrEqualTo(1000L))
                .body("totalResults", is(6))
                .body("number", is(10))
                // .log().all()
                .when()
                .get("/recipes/complexSearch");

    }

    @Test
    void soupSearchTest() {
        given()
                .param("query", "soup")
                .param("excludeIngredients", "tomato")
                //.log().method()
                .expect()
                .statusCode(200)
                .time(Matchers.lessThanOrEqualTo(1000L))
                .body("totalResults", is(286))
                .body(containsString("Pea Soup With Smoked Pork Ribs"))
                .body(containsString("652078"))
                .header("Content-Type", "application/json")
                .statusLine(containsString("OK"))
                .log().all()
                .when()
                .get("/recipes/complexSearch");

    }

    @Test
    void desertSearchTest() {
        given()
                .param("type", "dessert")
                .param("maxReadyTime", "15")
                .param("ignorePantry", "sugar")
                .expect()
                .statusCode(200)
                .time(Matchers.lessThanOrEqualTo(1000L))
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"))
                .header("Connection", is("keep-alive"))
                .log().all()
                .when()
                .get("/recipes/complexSearch");
    }

    @Test
    void proteinSearchTest() {
        given()
                .param("minProtein", "100")
                .expect()
                .statusCode(200)
                .time((Matchers.lessThanOrEqualTo(1000L)))
                .body(containsStringIgnoringCase("protein"))
                // .body("Total results", lessThanOrEqualTo(4))
                // .log().all()
                .when()
                .get("/recipes/complexSearch");
    }

    @Test
    void potatoSearchTitleTest() {
        given()
                .param("titleMatch", "potato")
                .expect()
                .statusCode(200)
                .time(lessThanOrEqualTo(1000L))
                .body("totalResults", is(178))
                .body(containsStringIgnoringCase("potato"))
                .when()
                .get("/recipes/complexSearch");

    }
}
