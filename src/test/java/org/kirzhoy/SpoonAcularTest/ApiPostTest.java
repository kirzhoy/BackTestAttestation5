package org.kirzhoy.SpoonAcularTest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ApiPostTest {

    @BeforeAll
    static void beforeAll() {
        baseURI = "https://api.spoonacular.com";
     /*   RestAssured.requestSpecification = new RequestSpecBuilder()
                .addParam("apiKey", "bb573bcaff9f47aabf2202cede5bb643")
                .build();*/
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }


    @Test
    void postPorkTest() {
        given()
                .queryParam("apiKey", "bb573bcaff9f47aabf2202cede5bb643")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Pork roast with green beans")
                .when()
                .post(baseURI + "/recipes/cuisine")
                .then()
                .statusCode(200);
    }

    @Test
    void postPotatoTest() {
        given()
                .queryParam("apiKey", "bb573bcaff9f47aabf2202cede5bb643")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Potato roast with green beans")
                .formParam("cuisine", "ukranian")
                .log().all()
                .when()
                .post(baseURI + "/recipes/cuisine")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void postMilkTest() {
        given()
                .queryParam("apiKey", "bb573bcaff9f47aabf2202cede5bb643")
                .header("Cache-Control", "no-cache")
                .contentType("application/x-www-form-urlencoded")
                .formParam("title", "Milk with honey")
                .formParam("cuisine", "russian")
                .log().all()
                .when()
                .post(baseURI + "/recipes/cuisine")
                .then()
                .statusCode(200);
    }
}
