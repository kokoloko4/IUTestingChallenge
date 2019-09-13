package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

public abstract class BasePage {

    WebDriver driver;

    BasePage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(this.driver, this);
    }

    /**
     * @param url The url that will be open in the browser.
     */
    public void openPage(String url) {
        driver.get(url);
    }

    /**
     * @return Return the WebDriverWait with implicit wait.
     */
    WebDriverWait getWebDriverWait(){
        return new WebDriverWait(driver, 10);
    }

    /**
     * @return True is the page loaded or false in opposite case.
     */
    public abstract boolean isPageLoaded();

}
