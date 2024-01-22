package desafioPet1.desafioPet1.pet;

import desafioPet1.desafioPet1.Utils.BaseApi;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class BuscarPetPorStatusTest extends BaseApi {

    @Test
    public void buscarAnimaisComStatusPendente() {

                given()
                    .contentType(ContentType.JSON)
                    .queryParam("status", "pending")
                .when()
                    .get("/pet/findByStatus")
                .then()
                    .log().all()
                    .extract().response();
    }

}
