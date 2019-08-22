package steps.useraccountSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import pages.HomePage;
import steps.RunnerHelper;
import pages.RegisterPage;

public class RegisterSteps {

    private RegisterPage registerPage;
    private HomePage homePage;

    public RegisterSteps(){
        homePage = new HomePage(RunnerHelper.driver);
        registerPage = new RegisterPage(RunnerHelper.driver);
    }

    @When("^I enter to register page$")
    public void IEnterToRegisterPage(){
        homePage.registerUser();
    }


    @And("^I fill all the fields except for \"celular\"")
    public void IFillAllTheFieldsExceptForCelular(){
        //RegisterPage registerPage = new RegisterPage(RunnerHelper.driver);
        registerPage.completeForm();
    }

    @And("^I try to save my data$")
    public void ITryToSaveMyData(){
        registerPage.saveData();
    }
}
