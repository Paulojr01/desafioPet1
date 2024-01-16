package desafioPet1.desafioPet1.pet;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;



public class PetTest {

    @Test
    public void shouldReturn404WhenFetchingNonexistentPetById (){

        baseURI = "https://petstore.swagger.io/v2";

        int petId = 50;

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .when()
                            .get("/pet/{petId}", petId)
                        .then()
                        .statusCode(404)
                        .log().all()
                        .extract().response();

    }

}
