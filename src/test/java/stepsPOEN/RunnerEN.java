package stepsPOEN;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = { "src/test/resources/featuresPOEN"}, // Onde est�o os cen�rios em Gherkin
        glue     = { "stepsPOEN"} ,  // Onde est�o as defini�oes de passos
        dryRun   = false,
        monochrome = true,
        plugin = {
                "pretty",                               //Formata��o visual do Cucumber
                "html:target/reports/extentreports",    //Saida HTML do Relat�rio Simples
                "json:target/reports/extentreports.json", //Saida Json com os dados
                "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/reports/dashboard.html"
        }
)
public class RunnerEN extends AbstractTestNGCucumberTests { //Equivale ao @RunWith do Junit

}
