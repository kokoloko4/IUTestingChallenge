package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(id = "header-login-modal")
    private WebElement loginButton;
    @FindBy(id = "emailAddress")
    private WebElement emailField;
    @FindBy(name = "password")
    private WebElement passwordField;
    @FindBy(id="searchQuestionSolr")
    private  WebElement searchBar;

    private By popUpLogin = By.xpath("//*[@class='Modal__modalcontent__2yJz6']");
    private By logoHomePage = By.xpath("//*[@class='fb-masthead__util-bar__link fb-masthead__util-bar__link--logo']");
    private By registerButton = By.xpath("//*[@class='Login__createAccount__38c2o']/a");
    private By loginButtonPopup = By.xpath("//*[@class='Button__main__1NDc9 Button__green__1fhy5']");
    private By userNameHomePage = By.xpath("//*[@class='fb-masthead-login__name re-design-cl__name']/strong");
    private By errorMessagePopupLogin = By.xpath("//*[@class='Login__errorText__13IML']");
    private By logoutButton = By.xpath("//*[contains(@class, 'fb-filter-header__log-out')]");
    private By textLoginButton = By.xpath("//*[@class='re-design-cl__logged']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private void loginPopup(){
        loginButton.click();
        getWebDriverWait().until(ExpectedConditions
                .visibilityOfElementLocated(popUpLogin));
    }

    public Boolean loadPage(){
        return driver.findElement(logoHomePage).isDisplayed();
    }

    public RegisterPage registerUser() {
        loginPopup();
        driver.findElement(registerButton).click();
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
        driver.findElement(loginButtonPopup).click();
    }

    public String getNameUserLogin(){
        getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(popUpLogin));
        return driver.findElement(userNameHomePage).getText();
    }

    public String getErrorMessageLogin(){
        return getWebDriverWait().until(ExpectedConditions
                .visibilityOfElementLocated(errorMessagePopupLogin)).getText();
    }

    public void logout(){
        getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(popUpLogin));
        Actions actions = new Actions(driver);
        actions.moveToElement(loginButton).perform();
        driver.findElement(logoutButton).click();
    }

    public String getTextMainPageLoginButton(){
        getWebDriverWait().until(ExpectedConditions.textToBe(textLoginButton, "Mi cuenta"));
        return driver.findElement(textLoginButton).getText();
    }

    public SearchPage findProduct(String product){
        searchBar.sendKeys(product);
        searchBar.sendKeys(Keys.ENTER);
        return new SearchPage(driver);
    }

}
