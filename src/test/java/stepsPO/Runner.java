package stepsPO;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = { "src/test/resources/featuresPO"}, // Onde estão os cenários em Gherkin
        glue     = { "stepsPO"} ,  // Onde estão as definiçoes de passos
        dryRun   = false,
        monochrome = true,
        plugin = {
                "pretty",                               //Formatação visual do Cucumber
                "html:target/reports/extentreports",    //Saida HTML do Relatório Simples
                "json:target/reports/extentreports.json" //Saida Json com os dados
                //"com.cucumber.listener.ExtentCucumberFormatter:target/reports/dashboard.html"
        }
)
public class Runner extends AbstractTestNGCucumberTests { //Equivale ao @RunWith do Junit

}
