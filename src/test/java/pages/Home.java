package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
    //Classe de Mapeamento possui 3 seções
    //1 - Mapeamento possui 3 seções
    WebDriver driver;
    @FindBy(id = "searchtext")
    WebElement caixaDePesquisa;
    //Similar ao que faziamos antes:
    //driver.findElement(By.id("searchText")

    @FindBy( id = "btn_form_search")
    WebElement botaoProcurar;

    // 2 - Constructor
    public Home(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void pesquisarPorCurso(String curso){
        caixaDePesquisa.click();
        caixaDePesquisa.clear();
        caixaDePesquisa.sendKeys(curso);
    }
    public void clicarNaLupa(){
        botaoProcurar.click();
    }
}
