package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseShoppingBagPage {
    protected WebDriver driver;

    public BaseShoppingBagPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("https://www.falabella.com.co/falabella-co/basket");
        PageFactory.initElements(driver, this);
    }
}
