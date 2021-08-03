package stepsPOEN;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class comprarCursoPOEN {

    @Before
    public void iniciarPO(){
        System.out.println("Passo 0");
    }

    @After
    public void finalizarPO(){
        System.out.println("Passo Z");
    }
    @Given("^que acesso o site da Iterasys POEN$")
    public void queAcessoOSiteDaIterasysPOEN() {
        System.out.println("Passo 1");
    }

    @When("^pesquiso por \"([^\"]*)\" PO$")
    public void pesquisoPorPOEN(String arg0){
        System.out.println("Passo 2");

    }

    @And("^clico na Lupa POEN$")
    public void clicoNaLupaPOEN() {
        System.out.println("Passo 4");
    }

    @Then("^vejo a lista de resultados para o curso \"([^\"]*)\" POEN$")
    public void vejoAListaDeResultadosParaOCursoPOEN(String arg0){

    }

    @When("^clico em Matricule-se POEN$")
    public void clicoEmMatriculeSePOEN() {
        System.out.println("Passo 5");
    }

    @Then("^confirmo o nome do curso como \"([^\"]*)\" e o preco de \"([^\"]*)\" POEN$")
    public void confirmoONomeDoCursoComoEOPrecoDePOEN(String arg0, String arg1){
        System.out.println("Passo 6");
    }
}
