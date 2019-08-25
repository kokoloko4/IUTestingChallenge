package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseHomePage {
    protected WebDriver driver;

    public BaseHomePage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("https://www.falabella.com.co");
        PageFactory.initElements(driver, this);
    }
}
