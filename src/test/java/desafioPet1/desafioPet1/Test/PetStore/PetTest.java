package desafioPet1.desafioPet1.Test.PetStore;

import desafioPet1.desafioPet1.Utils.BaseApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;



public class PetTest extends BaseApi {

    @Test
    public void shouldReturn404WhenFetchingNonexistentPetById (){


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
