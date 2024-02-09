package org.kirzhoy.lesson4Test;

import org.junit.jupiter.api.*;
import org.kirzhoy.lesson4.dto.Responce;
import static io.restassured.RestAssured.given;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)

public class HW4Test extends AbstractTest {
   public static Responce response;

   // @Order(1)
    @DisplayName("A")
    @Test
    void addToShoppingListTest() {  //body pojo request
        response = given()
                .spec(requestSpecification)
                .when()
                .post("/mealplanner/c1ad477d-8401-4e86-896c-22582e43f3b7/shopping-list" +
                        "/items?hash=a5dcc2addbb8c4eb5e685d09dbf71429113dc50d" +
                        "&apiKey=bb573bcaff9f47aabf2202cede5bb643")
                .then()
              //  .spec(responseSpecification)
                .extract()
                .response()
                .body()
                .as(Responce.class);
    }

    //@Order(2)
    @DisplayName("B")
    @Test
    void getFromShoppingListTest() {
        given()
                .spec(requestSpecificationWithApi)
                .when()
                .get("/mealplanner/c1ad477d-8401-4e86-896c-22582e43f3b7/shopping-list")
                .then()
                .spec(responseSpecification);
        //pojo for this response
    }

 //   @Order(3)
 @DisplayName("C")
    @Test
    void deleteFromShoppingListTest() {
       /* given()
                .spec(requestSpecificationWithApi)
                .delete("/mealplanner/c1ad477d-8401-4e86-896c-22582e43f3b7/shopping-list/items/" + response.getId())
                .then()
                .spec(responseSpecification);*/
    }
}

  /*  Написать тесты на запросы
  Add to Shopping list (POST /mealplanner/:username/shopping-list/items),
  Get Shopping List (GET /mealplanner/:username/shopping-list) и
  Delete from Shopping list (DELETE /mealplanner/:username/shopping-list/items/:id)
  используя Rest Assured*/