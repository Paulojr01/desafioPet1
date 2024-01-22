package desafioPet1.desafioPet1.order;

import desafioPet1.desafioPet1.Utils.BaseApi;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class PedidoTest extends BaseApi {

    @Test
    public void deveCriarNovoPedidoDeAnimalComSucesso() {


        LocalDateTime dataHoraAtual = LocalDateTime.now();
        DateTimeFormatter formataDataHora = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String dataHoraFormatada = dataHoraAtual.format(formataDataHora);

                String requestBody = "{\n" +
                "  \"id\": 1,\n" +
                "  \"petId\": 1,\n" +
                "  \"quantity\": 1,\n" +
                "  \"shipDate\": \"" + dataHoraFormatada + "\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true\n" +
                "}";

        Response response = given()
                    .body(requestBody)
                    .contentType(ContentType.JSON)
                .when()
                .post("/store/order")
                .then()
                    .log().all()
                    .body("id", notNullValue())
                    .body("petId", notNullValue())
                    .body("quantity", notNullValue())
                    .body("status", equalTo("placed"))
                    .body("complete", equalTo(true))
                    .extract().response();

        String responseBody = response.getBody().asString();
        JsonPath jsonPath = new JsonPath(responseBody);

        int orderId = jsonPath.getInt("id");
        assertThat(orderId, both(greaterThan(0)).and(lessThan(50)));

        int petId = jsonPath.getInt("petId");
        assertThat(petId, both(greaterThan(0)).and(lessThan(50)));

        int quantityDePet = jsonPath.getInt("quantity");
        assertThat(quantityDePet, both(greaterThan(0)).and(lessThan(50)));


    }
}






