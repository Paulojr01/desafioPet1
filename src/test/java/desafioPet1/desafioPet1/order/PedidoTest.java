package desafioPet1.desafioPet1.order;

import desafioPet1.desafioPet1.Dados.Dados;
import desafioPet1.desafioPet1.Utils.BaseApi;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class PedidoTest extends BaseApi {

    Dados dados = new Dados();

    @Test
    public void criarNovoPedidoAnimalComSucesso() {

        Map requestBody = dados.dadosPedidoTest200();

        given()
                .body(requestBody)
                .contentType(ContentType.JSON)
                .when()
                .post("/store/order")
                .then()
                .statusCode(200)
                .log().all()
                .body("id", notNullValue())
                .body("petId", notNullValue())
                .body("quantity", notNullValue())
                .body("status", equalTo("placed"))
                .body("complete", equalTo(true));
    }

}






