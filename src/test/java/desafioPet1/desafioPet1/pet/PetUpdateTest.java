package desafioPet1.desafioPet1.pet;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class PetUpdateTest {

    @Test
    public void updatePetWithRequestBody() {
        baseURI = "https://petstore.swagger.io/v2";

        String requestBody = "{\n" +
                "  \"id\": 10,\n" +
                "  \"category\": {\n" +
                "    \"id\": 2,\n" +
                "    \"name\": \"Retriever\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"https://www.enciclopet.com.br/wp-content/uploads/2016/09/golden-retriever.jpg\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        Response response = given()
                    .body(requestBody)
                    .contentType(ContentType.JSON)
                .when()
                    .put("/pet")
                .then()
                    .log().all()
                    .body("id", notNullValue())
                    .body("category.id", notNullValue())
                    .body("category.name", notNullValue())
                    .body("name", notNullValue())
                    .body("photoUrls[0]", notNullValue())
                    .body("tags[0].id", equalTo(0))
                    .body("tags[0].name", notNullValue())
                    .body("status", equalTo("available"))
                .extract().response();


        String responseBody = response.getBody().asString();
        JsonPath jsonPath = new JsonPath(responseBody);

        int orderId = jsonPath.getInt("id");
        assertThat(orderId, both(greaterThan(0)).and(lessThan(50)));

        int petId = jsonPath.getInt("category.id");
        assertThat(petId, both(greaterThan(0)).and(lessThan(50)));


    }
}
