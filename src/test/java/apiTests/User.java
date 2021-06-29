package apiTests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.stringContainsInOrder;

public class User {
    String uri = "https://petstore.swagger.io/v2/user";
    int userId = 1023;
    String userName = "UserTeste1023";
    String password = "passwd";
    String token = "";

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }
    @Test(priority = 0)
    public void incluirUsuario() throws IOException {

        //Padrão
        //Given = Dado
        //.When = Quando
        //.Then = Então
        String jsonBody = lerJson("src/test/resources/data/user.json");

        given()                                             //Dado
                .contentType("application/json")            //Tipo do conteúdo
                .log().all()                                //registrar tudo do envio
                .body(jsonBody)
        .when()                                                //Quando
                .post(uri)   //Comando + endpoint
        .then()                                                 //então
                .log().all()                                        //Registrar tudo da volta
                .statusCode(200)                                //Valida o Codigo do Estado
                //.body("id", is(userId))           //Valida o Id do Usuario
                //.body("username" , is("UserTeste1023"))    //Valida o login do Usuario
                //.body("firstName", is("NomeTeste"))
                //.body("lastName", is("Ultimo nome"))
                //.body("email", is("emailtesteswagger@emailtesteswagger.com.br"))
                //.body("password", is("passwd"))
                //.body("phone", is("1199999-9999"))
                //.body("userStatus", is(0))
                .body("message", is(Integer.toString(userId)))

        ;
    }

    @Test(priority = 1, dependsOnMethods = {"incluirUsuario"})
    public void consultarUser(){

        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(uri + "/" + userName)
        .then()
                .log().all()                                        //Registrar tudo da volta
                .statusCode(200)
                //.body("id", is(userId))           //Valida o Id do Usuario
                .body("username" , is("UserTeste1023"))    //Valida o login do Usuario
                .body("firstName", is("NomeTeste"))
                .body("lastName", is("Ultimo nome"))
                .body("email", is("emailtesteswagger@emailtesteswagger.com.br"))
                .body("password", is("passwd"))
                .body("phone", is("1199999-9999"))
                .body("userStatus", is(0))
        ;
    }
    @Test(priority = 2, dependsOnMethods = {"consultarUser"})
    public void alterarUser() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/alteruser.json");

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody) //Json a ser transmitido para a alteração
        .when()
                .put(uri + "/" + userName)
        .then()
                .statusCode(200)
                //.body("status", is(1))
                .body("message", is("1023"))
        ;
    }
    @Test(priority = 3, dependsOnMethods = {"alterarUser"})
    public void excluirUser(){

        given()
                .contentType("application/json")
                .log().all()
        .when()
                .delete(uri + "/" + userName)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is("UserTeste1023"))
        ;
    }

    @Test
    public void login(){
        //String[] textoSeparado = alunoRecebido.split(":");
        //String token2 = "";
        String mensagem =
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(uri + "/login?username=" + userName +"&password=" + password)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
        .extract()
                .path("message" )
        ;

        System.out.println("A mensagem é : " + mensagem);
        token = mensagem.substring(24);
        System.out.println("O token é :" + token);

    }
}
