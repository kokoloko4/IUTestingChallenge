package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BaseHomePage {

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
    @FindBy(xpath = "//*[@value='female']")
    private WebElement femaleGender;
    @FindBy(id = "day")
    private WebElement day;
    @FindBy(id = "month")
    private WebElement month;
    @FindBy(id = "year")
    private WebElement year;
    @FindBy(id = "celular")
    private WebElement phone;
    @FindBy(id = "boton_Ar")
    private WebElement saveRegistry;
    @FindBy(id = "agreelegaleId")
    private WebElement termsConditions;
    @FindBy(id = "mensajeCelVacio")
    private WebElement errorMessage;
    @FindBy(id = "contRegistroHeader")
    private WebElement formTitle;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public Boolean loadPage(){
        if(formTitle != null){
            return true;
        }
        return false;
    }

    public void fillField(String fieldName, String value){
        if(fieldName.equals("name")){
            userName.sendKeys(value);
        }else if(fieldName.equals("fathersLastName")){
            fathersLastName.sendKeys(value);
        }else if(fieldName.equals("mothersLastName")){
            mothersLastName.sendKeys(value);
        }else if(fieldName.equals("email")){
            email.sendKeys(value);
        }else if(fieldName.equals("password")){
            password.sendKeys(value);
        }else if(fieldName.equals("confirmPassword")) {
            confirmPassword.sendKeys(value);
        }else if(fieldName.equals("id")){
            id.sendKeys(value);
        }
    }

    public void selectGender(String gender){
        if(gender.equals("Hombre")){
            maleGender.click();
        }else{
            femaleGender.click();
        }
    }

    public void putBirthday(String dayValue, String monthValue, String yearValue){
        day.click();
        driver.findElement(By.xpath("//*[@id='day']//*[@value='"+dayValue+"']")).click();
        month.click();
        driver.findElement(By.xpath("//*[@id='month']//*[@value='"+monthValue+"']")).click();
        year.click();
        driver.findElement(By.xpath("//*[@id='year']//*[@value='"+yearValue+"']")).click();
    }

    public void checkTermsConditions(){
        termsConditions.click();
    }

    public void saveData(){
        saveRegistry.click();
    }

    public String getErrorMessage(){
       return errorMessage.getText();
    }
}
