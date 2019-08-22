package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(id = "user")
    private WebElement userName;
    @FindBy(id = "apellidopaterno")
    private WebElement fathersLastName;
    @FindBy(id = "apellidomaterno")
    private WebElement mothersLastName;
    @FindBy(id = "mail")
    private WebElement email;
    @FindBy(id = "clave1")
    private WebElement password;
    @FindBy(id = "clave2")
    private WebElement confirmPassword;
    @FindBy(id = "cedula_colombia")
    private WebElement id;
    @FindBy(xpath = "//*[@value='male']")
    private WebElement maleGender;
    @FindBy(xpath = "//*[@id='day']/option[@value='2']")
    private WebElement day;
    @FindBy(xpath = "//*[@id='month']/option[@value='05']")
    private WebElement month;
    @FindBy(xpath = "//*[@id='year']/option[@value='1998']")
    private WebElement year;
    @FindBy(id = "boton_Ar")
    private WebElement saveRegistry;
    @FindBy(id = "mensajeCelVacio")
    private WebElement errorMessage;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    private void populateField(WebElement webElement, String data){
        webElement.click();
        webElement.sendKeys(data);
    }

    public void completeForm(){
        populateField(userName,"Juan");
        populateField(fathersLastName, "Rodriguez");
        populateField(mothersLastName, "López");
        populateField(email, "ejemplo@hotmail.com");
        populateField(password, "password123");
        populateField(confirmPassword, "password123");
        populateField(id, "1235654325");
        maleGender.click();
        day.click();
        month.click();
        year.click();
    }

    public void saveData(){
        saveRegistry.click();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }

}
