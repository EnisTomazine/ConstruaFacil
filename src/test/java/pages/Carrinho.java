package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Carrinho {
    //Classe de Mapeamento possui 3 se��es
    //1 - Mapeamento possui 3 se��es
    WebDriver driver;
    @FindBy(css = "span.item-title")
    WebElement itemTitulo;

    @FindBy(css = "span.new-price")
    WebElement itemPreco;


    // 2 - Constructor
    public Carrinho(WebDriver driver) {
        this.driver = driver;
    }

    //Duvida
    //public void pesquisarPorCurso(String curso){
     //   itemTitulo.getText();
    //}

}
