package org.kirzhoy.SpoonAcularTest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ApiFoodChainTest {

   @Test
    void foodChainTest() {
      /*  String id =  given()
              .body("{\n"
                        + " \"date\": 1644881179,\n"
                        + " \"slot\": 1,\n"
                        + " \"position\": 0,\n"
                        + " \"type\": \"INGREDIENTS\",\n"
                        + " \"value\": {\n"
                        + " \"ingredients\": [\n"
                        + " {\n"
                        + " \"name\": \"1 orange\"\n"
                        + " }\n"
                        + " ]\n"
                        + " }\n"
                        + "}")
                .log().all()
                .when()
                .post("https://api.spoonacular.com/mealplanner/c1ad477d-8401-4e86-896c-22582e43f3b7/items?hash=a5dcc2addbb8c4eb5e685d09dbf71429113dc50d&apiKey=bb573bcaff9f47aabf2202cede5bb643")
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .jsonPath()
                .get("id")
                .toString();

        System.out.println(id);
        given()
                .queryParam("hash", "a5dcc2addbb8c4eb5e685d09dbf71429113dc50d")
                .queryParam("apiKey", "bb573bcaff9f47aabf2202cede5bb643")
                .delete("https://api.spoonacular.com/mealplanner/c1ad477d-8401-4e86-896c-22582e43f3b7/items/" + id)
                .then()
                .statusCode(200)
                .log().all();*/
    }

}
