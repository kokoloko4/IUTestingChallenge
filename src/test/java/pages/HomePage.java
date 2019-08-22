package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(id = "header-login-modal")
    private WebElement loginButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    private void loginPopup(){
        loginButton.click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 3);
        webDriverWait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@class=\"Modal__modalcontent__2yJz6\"]")));
    }
    public RegisterPage registerUser(){
        loginPopup();
        WebElement registerButton = driver.findElement(By.xpath("//*[@class=\"Login__createAccount__38c2o\"]/a"));
        registerButton.click();
        return new RegisterPage(driver);
    }
}
