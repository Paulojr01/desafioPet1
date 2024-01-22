package desafioPet1.desafioPet1.Utils;


import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;

import static io.restassured.RestAssured.*;

public class BaseApi {

    @BeforeEach
    public   void preCondicao (){
        baseURI = "https://petstore.swagger.io/v2";
    }
}
