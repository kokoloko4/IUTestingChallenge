package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BaseProductPage {

    protected WebDriver driver;

    public BaseProductPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("https://www.falabella.com.co/falabella-co/product/3000165/Consola-Switch-Neon-Azul-Rojo/3000165");
        PageFactory.initElements(driver, this);
    }
}
