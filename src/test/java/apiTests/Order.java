package apiTests;


import org.hamcrest.text.StringContainsInOrder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Order {

    String uri = "https://petstore.swagger.io/v2/store/order";
    int petId = 1123;


    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test(priority = 0)
    public void incluirOrder() throws IOException {

        String jsonBody = lerJson("src/test/resources/data/order.json");

        given()                                             //Dado
                .contentType("application/json")            //Tipo do conteúdo
                .log().all()                                //registrar tudo do envio
                .body(jsonBody)
        .when()                                                //Quando
                .post(uri)   //Comando + endpoint
        .then()                                                 //então
                .log().all()                                        //Registrar tudo da volta
                .statusCode(200)                                //Valida o Codigo do Estado
                .body("petId", is(petId))           //Valida o petId
                .body("quantity", is(10))    //Valida a quantidade
                //.body("shipDate", is("2021-07-13T21:39:40.937Z")) //valida a data
                .body("status", is("placed"))
        ;
    }

    @Test(priority = 1, dependsOnMethods = {"incluirOrder"})
    public void consultarOrder() {
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(uri + "/" + petId)
        .then()                                                 //então
                .log().all()                                        //Registrar tudo da volta
                .statusCode(200)
                .body("petId", is(petId))           //Valida o petId
                .body("quantity", is(10))    //Valida a quantidade
                //.body("shipDate", contains("2021-07-13T21:39:40.937Z")) //valida a data
                .body("status", is("placed"))
        ;
    }

    @Test(priority = 2, dependsOnMethods = {"consultarOrder"})
    public void excluirOrder() {

        given()
                .contentType("application/json")
                .log().all()
        .when()
                .delete(uri + "/" + petId)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(Integer.toString(petId)))
        ;
    }


}
