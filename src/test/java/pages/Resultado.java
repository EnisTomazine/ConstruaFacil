package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Resultado {
    //Classe de Mapeamento possui 3 seções
    //1 - Mapeamento possui 3 seções
    WebDriver driver;
    @FindBy(css = "span.comprar")
    WebElement btnMatriculese;

    // 2 - Constructor
    public Resultado(WebDriver driver) {
        this.driver = driver;
    }

    public void pesquisarPorCurso(String curso){
        btnMatriculese.click();
    }
}
