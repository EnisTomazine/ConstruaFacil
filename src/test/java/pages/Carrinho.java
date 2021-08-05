package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Carrinho {

    WebDriver driver;
    @FindBy(css = "span.item-title")
    WebElement itemTitulo;

    @FindBy(css = "span.new-price")
    WebElement itemPreco;

    public Carrinho(WebDriver driver) {
        this.driver = driver;
    }



}
