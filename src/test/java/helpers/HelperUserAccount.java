package helpers;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.RegisterPage;
import steps.RunnerHelper;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class HelperUserAccount {

    private static final WebDriver driver = RunnerHelper.driver;
    private static HomePage homePage = new HomePage(driver);
    private static RegisterPage registerPage;

    public static void getHomePage(){
        assertTrue("Home page does not load",homePage.loadPage());
    }

    public static void getLoginPage(){
        homePage.login();
    }

    public static void getRegisterPage() {
        registerPage = homePage.registerUser();
        assertTrue(registerPage.loadPage());
    }

    public static void completeField(String fieldName, String value, String form){
        if (form.equals("register")){
            registerPage.fillField(fieldName, value);
        }else if(form.equals("login")){
            homePage.fillField(fieldName, value);
        }
    }

    public static void selectGender(String gender){
        registerPage.selectGender(gender);
    }

    public static void setBirthday(String day, String month, String year){
        registerPage.putBirthday(day, month, year);
    }

    public static void completeRegisterForm(){
        registerPage.checkTermsConditions();
        registerPage.saveData();
    }

    public static void verifyThatPhoneIsMissing(){
        assertThat("The message of missing phone number is missing",
                registerPage.getErrorMessage(), equalTo("Debes ingresar un celular"));
    }

    public static void completeLoginForm(){
        homePage.sendLogin();
    }

    public static void verifyUserLogin(String name){
        assertThat("The name does not match", homePage.getNameUserLogin() , equalTo(name));
    }

    public static void verifyErrorLogin(){
        assertThat("The login error message is not correct", homePage.getErrorMessageLogin(),
                equalTo("E-mail o clave incorrecta. Por favor inténtalo nuevamente."));
    }

    public static void logout(){
        homePage.logout();
    }

    public static void verifyUserIsLogout(){
        assertThat("Log out does not work", homePage.getTextMainPageLoginButton(),
                equalTo("Mi cuenta"));
    }
}
