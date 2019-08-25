package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseHomePage {

    @FindBy(id = "header-login-modal")
    private WebElement loginButton;
    @FindBy(id = "emailAddress")
    private WebElement emailField;
    @FindBy(name = "password")
    private WebElement passwordField;
    @FindBy(id="searchQuestionSolr")
    private  WebElement searchBar;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private void loginPopup(){
        loginButton.click();
        getWebDriverWait().until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@class='Modal__modalcontent__2yJz6']")));
    }

    public Boolean loadPage(){
        if(driver.findElement(By.xpath("//*[@class='fb-masthead__util-bar__link fb-masthead__util-bar__link--logo']")).isDisplayed()){
            return true;
        }
        return false;
    }

    public RegisterPage registerUser() {
        loginPopup();
        WebElement registerButton = driver.findElement(By.xpath("//*[@class='Login__createAccount__38c2o']/a"));
        registerButton.click();
        return new RegisterPage(driver);
    }

    public void login(){
        loginPopup();
    }

    public void fillField(String fieldName, String value){
        if (fieldName.equals("email")){
            emailField.sendKeys(value);
        }else if(fieldName.equals("password")){
            passwordField.sendKeys(value);
        }
    }

    public void sendLogin(){
        driver.findElement(By.xpath("//*[@class='Button__main__1NDc9 Button__green__1fhy5']")).click();
    }

    public String getNameUserLogin(){
        getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//*[@class='Modal__modalcontent__2yJz6']")));
        return driver.findElement(By.xpath("//*[@class='fb-masthead-login__name re-design-cl__name']/strong")).getText();
    }

    public String getErrorMessageLogin(){
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@class='Login__errorText__13IML']")));
        return driver.findElement(By.xpath("//*[@class='Login__errorText__13IML']")).getText();
    }

    public void logout(){
        getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//*[@class='Modal__modalcontent__2yJz6']")));
        Actions actions = new Actions(driver);
        actions.moveToElement(loginButton).perform();
        driver.findElement(By.xpath("//*[contains(@class, 'fb-filter-header__log-out')]")).click();
    }

    public String getTextMainPageLoginButton(){
        getWebDriverWait().until(ExpectedConditions.textToBe(
                By.xpath("//*[@class='re-design-cl__logged']"), "Mi cuenta"));
        return driver.findElement(By.xpath("//*[@class='re-design-cl__logged']")).getText();
    }

    public SearchPage findProduct(String product){
        searchBar.sendKeys(product);
        searchBar.sendKeys(Keys.ENTER);
        return new SearchPage(driver);
    }

    private WebDriverWait getWebDriverWait(){
        return new WebDriverWait(driver, 3);
    }
}
