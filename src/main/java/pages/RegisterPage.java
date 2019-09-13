package pages;

import org.openqa.selenium.By;
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

    public RegisterPage() {
        super();
    }

    @Override
    public boolean isPageLoaded() {
        return formTitle.isDisplayed();
    }

    /**
     * @param fieldName The name of the field in the form
     * @param value The value that will be send to the field in the form
     */
    public void fillField(String fieldName, String value){
        switch (fieldName) {
            case "name":
                userName.clear();
                userName.sendKeys(value);
                break;
            case "fathersLastName":
                fathersLastName.clear();
                fathersLastName.sendKeys(value);
                break;
            case "mothersLastName":
                mothersLastName.clear();
                mothersLastName.sendKeys(value);
                break;
            case "email":
                email.clear();
                email.sendKeys(value);
                break;
            case "password":
                password.clear();
                password.sendKeys(value);
                break;
            case "confirmPassword":
                confirmPassword.clear();
                confirmPassword.sendKeys(value);
                break;
            case "id":
                id.clear();
                id.sendKeys(value);
                break;
        }
    }

    /**
     * @param gender The gender that will be check in the form
     */
    public void selectGender(String gender){
        if(gender.equals("Hombre")){
            maleGender.click();
        }else{
            femaleGender.click();
        }
    }

    /**
     * @param dayValue The day that will be selected in the combo box at form
     * @param monthValue The month that will be selected in the combo box at form
     * @param yearValue The year that will be selected in the combo box at form
     */
    public void putBirthday(String dayValue, String monthValue, String yearValue){
        day.click();
        driver.findElement(By.xpath("//*[@id='day']//*[@value='"+dayValue+"']")).click();
        month.click();
        driver.findElement(By.xpath("//*[@id='month']//*[@value='"+monthValue+"']")).click();
        year.click();
        driver.findElement(By.xpath("//*[@id='year']//*[@value='"+yearValue+"']")).click();
    }

    /**
     * Check the terms and conditions checkbox
     */
    public void checkTermsConditions(){
        termsConditions.click();
    }

    /**
     * Click hover "Guardar" button at the registration form
     */
    public void saveData(){
        saveRegistry.click();
    }

    /**
     * @return The error message that appeas whn the cellphone is empty
     */
    public String getErrorMessage(){
       return errorMessage.getText();
    }
}
