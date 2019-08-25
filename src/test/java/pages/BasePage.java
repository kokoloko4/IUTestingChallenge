package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void setPage(String url){
        driver.get(url);
    }

    public WebDriverWait getWebDriverWait(){
        return new WebDriverWait(driver, 10);
    }

}
