package org.kirzhoy.lesson4Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

import java.io.IOException;


public class AbstractTest {
    public static ResponseSpecification responseSpecification;
    public static RequestSpecification requestSpecification;

    public static RequestSpecification requestSpecificationWithApi;

    public static RequestSpecification requestSpecificationWithApiDel;


    @BeforeAll
    static void initTest() {
        RestAssured.baseURI = "https://api.spoonacular.com";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        requestSpecificationWithApi = new RequestSpecBuilder()
                .addParam("apiKey", "bb573bcaff9f47aabf2202cede5bb643")
                .addParam("hash","a5dcc2addbb8c4eb5e685d09dbf71429113dc50d")
                .addQueryParam("includeNutrition", "false")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(5000L))
                .build();
    }

}



