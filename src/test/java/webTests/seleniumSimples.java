
// 1- Pacote
        package webTests;
// 2 - Bibliotecas

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;
import utils.Evidencias;

// 3 - Classes
public class seleniumSimples {
    //3.1 - Atributos
    WebDriver driver;
    Evidencias evidencias;
    static String dataHoraF = new SimpleDateFormat("yyyy-MM-dd HH:mm").getCalendar().getTime().toString();
    static String dataHora = dataHoraF.replaceAll(":","-");
    //3.2 - Metodos e Funçoes

    @BeforeMethod
    public void iniciar(){
        // A- Inicio
        System.setProperty("webdriver.chrome.driver","drivers/chrome/91/chromedriver.exe");
        //Instancia o objeto driver como um controlador do Chrome
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        evidencias = new Evidencias(); //instanciar
    }
    @Test(priority = 1)
    public void consultaCursoMantis() throws IOException {
        String casoDeTeste = "Consultar Curso Mantis";
        //B- Realizar o teste

        driver.get("https://www.iterasys.com.br");                              //Abre o site alvo informado
        evidencias.print(driver, dataHora ,casoDeTeste,"Passo 1 - Abriu o site");
        driver.findElement(By.id("searchtext")).click();                        //Clica no campo de pesquisa
        driver.findElement(By.id("searchtext")).clear();                        //Limpa o campo de pesquisa
        driver.findElement(By.id("searchtext")).sendKeys("mantis");  //Escreve "mantis" no campo
        evidencias.print(driver, dataHora , casoDeTeste, "Passo 2 - Digitou Mantis");
        driver.findElement(By.id("btn_form_search")).click();                   //Clique na lupa

        assertEquals(driver.findElement(By.cssSelector("H3")).getText(),"Cursos › \"mantis\"");

        //assertThat(driver.findElement(By.cssSelector("h3")).getText(), is("Cursos › \\\"mantis\\\""));
        evidencias.print(driver, dataHora , casoDeTeste, "Passo 3 - Exibiu a lista de cursos");
        driver.findElement(By.cssSelector("span.comprar")).click();
        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(), "Mantis" );
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(), "R$ 49,99" );
        evidencias.print(driver, dataHora , casoDeTeste, "Passo 4 - Exibiu o carrinho de compras");



    }

    @Test(priority = 2)
    public void consultaCursoCtfl() throws IOException {
        String casoDeTeste = "Consultar Curso preparatório ctfl";
        //B - Realizar o teste

        driver.get("https://www.iterasys.com.br");                              //Abre o site alvo informado
        evidencias.print(driver, dataHora , casoDeTeste, "Passo 1 - Abriu o site");
        driver.findElement(By.id("searchtext")).click();                        //Clica no campo de pesquisa
        driver.findElement(By.id("searchtext")).clear();                        //Limpa o campo de pesquisa
        driver.findElement(By.id("searchtext")).sendKeys("preparatório ctfl");  //Escreve "mantis" no campo
        evidencias.print(driver, dataHora , casoDeTeste, "Passo 2 - Digitou preparatório ctfl");

        driver.findElement(By.id("btn_form_search")).click();                   //Clique na lupa

        assertEquals(driver.findElement(By.cssSelector("H3")).getText(),"Cursos › \"preparatório ctfl\"");

        //assertThat(driver.findElement(By.cssSelector("h3")).getText(), is("Cursos › \\\"mantis\\\""));
        evidencias.print(driver, dataHora , casoDeTeste, "Passo 3 - Exibiu a lista de cursos");
        driver.findElement(By.cssSelector("span.comprar")).click();
        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(), "Preparatório CTFL" );
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(), "R$ 169,00" );
        evidencias.print(driver, dataHora , casoDeTeste, "Passo 4 - Exibiu o carrinho de compras");

    }

    @AfterMethod
    public void finalizar(){
        //Parte C - Encerramento
        //driver.quit();
    }

}
