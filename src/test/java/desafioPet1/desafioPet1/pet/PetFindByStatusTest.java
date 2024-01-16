package desafioPet1.desafioPet1.pet;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PetFindByStatusTest {

    @Test
    public void searchPetsWithPendingStatus() {
        baseURI = "https://petstore.swagger.io/v2";

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
