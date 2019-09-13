package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    private By loginButtonPopup = By.xpath("//*[@class='Button__main__1NDc9 Button__green__1fhy5']");
    private By userNameHomePage = By.xpath("//*[@class='fb-masthead-login__name re-design-cl__name']/strong");
    private By errorMessagePopupLogin = By.xpath("//*[@class='Login__errorText__13IML']");
    private By logoutButton = By.xpath("//*[contains(@class, 'fb-filter-header__log-out')]");
    private By textLoginButton = By.xpath("//*[@class='re-design-cl__logged']");

    public HomePage() {
        super();
    }

    @Override
    public boolean isPageLoaded() {
        return driver.findElement(logoHomePage).isDisplayed();
    }

    /**
     * Wait until the login pop up appears
     */
    public void login(){
        loginButton.click();
        getWebDriverWait().until(ExpectedConditions
                .visibilityOfElementLocated(popUpLogin));
    }

    /**
     * @param fieldName The field that will be filled (email or password)
     * @param value The value that will be send to the field
     */
    public void fillField(String fieldName, String value){
        if (fieldName.equals("email")){
            emailField.clear();
            emailField.sendKeys(value);
        }else if(fieldName.equals("password")){
            emailField.clear();
            passwordField.sendKeys(value);
        }
    }

    /**
     * Click hover "Iniciar sesión" button
     */
    public void sendLogin(){
        driver.findElement(loginButtonPopup).click();
        getWebDriverWait();
    }

    /**
     * @return The name of the user once is logged
     */
    public String getNameUserLogin(){
        getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(popUpLogin));
        return driver.findElement(userNameHomePage).getText();
    }

    /**
     * @return The error message when is the user types the incorrect email or password
     */
    public String getErrorMessageLogin(){
        return getWebDriverWait().until(ExpectedConditions
                .visibilityOfElementLocated(errorMessagePopupLogin)).getText();
    }

    /**
     * Click on the logoutbutton
     */
    public void logout(){
        getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(popUpLogin));
        Actions actions = new Actions(driver);
        actions.moveToElement(loginButton).perform();
        driver.findElement(logoutButton).click();
    }

    /**
     * @return The text of login button when is logout
     */
    public String getTextMainPageLoginButton(){
        getWebDriverWait().until(ExpectedConditions.textToBe(textLoginButton, "Mi cuenta"));
        return driver.findElement(textLoginButton).getText();
    }

    /**
     * @param product Search a product
     */
    public void findProduct(String product){
        searchBar.sendKeys(product);
        searchBar.sendKeys(Keys.ENTER);
        getWebDriverWait();
    }

}
