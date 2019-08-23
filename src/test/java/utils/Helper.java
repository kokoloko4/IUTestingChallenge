package utils;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.RegisterPage;
import steps.RunnerHelper;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class Helper {

    private static final WebDriver driver = RunnerHelper.driver;
    private static HomePage homePage =  new HomePage(driver);
    private static RegisterPage registerPage;

    public void getHomePage(){
        assertTrue(homePage.loadPage());
    }

    public void getPopup(){

    }

    public static void getRegisterPage(){
        registerPage = homePage.registerUser();
        assertTrue(registerPage.loadPage());
    }

    public static void completeField(String fieldName, String value){
        registerPage.fillField(fieldName, value);
    }

    public static void selectGender(String gender){
        registerPage.selectGender(gender);
    }

    public static void setBirthday(String day, String month, String year){
        registerPage.putBirthday(day, month, year);
    }

    public static void completeForm(){
        registerPage.checkTermsConditions();
        registerPage.saveData();
    }
}
