package apiTests;

import org.hamcrest.text.StringContainsInOrder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Pet {
    String uri = "https://petstore.swagger.io/v2/pet";
    int petId = 1123;

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }
    @Test(priority = 0)
    public void incluirPet() throws IOException {

        //Padrão
        //Given = Dado
        //.When = Quando
        //.Then = Então
        String jsonBody = lerJson("src/test/resources/data/pet.json");

        given()                                             //Dado
                .contentType("application/json")            //Tipo do conteúdo
                //"text/xml" para web servicer sincronos - Ex: Correios
                //"application/json" para web services assincronos - ex: iFood
                .log().all()                                //registrar tudo do envio
                .body(jsonBody)
        .when()                                                //Quando
            .post(uri)   //Comando + endpoint
        .then()                                                 //então
            .log().all()                                        //Registrar tudo da volta
                .statusCode(200)                                //Valida o Codigo do Estado
                //.body("code", is(200))                 //Valida o Código de estado no Json
                .body("id", is(petId))           //Valida o Id do Animal
                .body("name" , is("Teste1"))    //Valida o nome do Animal
                .body("category.name", is("dog")) //valida a categoria do Animal
                //.body("tags.name", not(contains("animal")))
                .body("tags.name[0]", stringContainsInOrder("vermi"))
        ;
    }

    @Test(priority = 1, dependsOnMethods = {"incluirPet"})
    public void consultarPet(){
        //String petId = "1123"; //Id do Animal

        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(uri + "/" + petId)
        .then()                                                 //então
            .log().all()                                        //Registrar tudo da volta
            .statusCode(200)
                .body("name", is("Teste1"))
                .body( "status", is("available"))
        ;
    }
    @Test(priority = 2, dependsOnMethods = {"consultarPet"})
    public void alterarPet() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/newpet.json");

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody) //Json a ser transmitido para a alteração
        .when()
                .put(uri)
        .then()
                .statusCode(200)
                .body("status", is("sold"))
        ;
    }
    @Test(priority = 3, dependsOnMethods = {"alterarPet"})
    public void excluirPet(){

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
