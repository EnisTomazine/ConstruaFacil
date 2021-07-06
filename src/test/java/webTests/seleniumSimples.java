// 1- Pacote
package webTests;
// 2 - Bibliotecas

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

// 3 - Classes
public class seleniumSimples {
    //3.1 - Atributos
    WebDriver driver;
    //3.2 - Metodos e Funçoes
    @Test
    public void consultaCurso(){
        // A- Inicio
        System.setProperty("webdriver.chrome.driver","drivers/chrome/91/chromedriver.exe");
        //Instancia o objeto driver como um controlador do Chrome
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3000000, TimeUnit.MILLISECONDS);

        //8 - Realizar o teste

        driver.get("https://www.iterasys.com.br");                              //Abre o site alvo informado
        driver.findElement(By.id("searchtext")).click();                        //Clica no campo de pesquisa
        driver.findElement(By.id("searchtext")).clear();                        //Limpa o campo de pesquisa
        driver.findElement(By.id("searchtext")).sendKeys("mantis");  //Escreve "mantis" no campo

        driver.findElement(By.id("btn_form_search")).click();                   //Clique na lupa

        assertEquals(driver.findElement(By.cssSelector("H3")).getText(),"Cursos › \"mantis\"");

        //assertThat(driver.findElement(By.cssSelector("h3")).getText(), is("Cursos › \\\"mantis\\\""));

        driver.findElement(By.cssSelector("span.comprar")).click();
        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(), "Mantis" );
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(), "R$ 49,99" );
        driver.quit();


    }

}
