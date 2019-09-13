package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.RegisterPage;
import utils.PageUrls;

import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AccountSteps{

    private static HomePage homePage;
    private static RegisterPage registerPage;

    public AccountSteps() {
        homePage = new HomePage();
        registerPage = new RegisterPage();
    }

    @Given("^I am in Falabella homepage$")
    public void iAmInFalabellaHomepage(){
        homePage.openPage(PageUrls.getHomePageUrl());
        assertTrue("Home page does not loaded",homePage.isPageLoaded());
    }

    @Given("^I am in Falabella registration page$")
    public void iAminRegistration(){
        registerPage.openPage(PageUrls.getRegistrationPageUrl());
        assertTrue("Registration page is not loaded", registerPage.isPageLoaded());
    }

    @When("^I enter in login form$")
    public void iEnterInLoginForm(){
        homePage.login();
    }

    @When("^I sign out$")
    public void iSignOut(){
        homePage.logout();
    }

    @And("^I click hover login button$")
    public void iClickHoverLoginButton(){
        homePage.sendLogin();
    }

    @When("^I complete the registration form$")
    public void iCompleteField(Map<String,String> registrationInfo){
        for(String key: registrationInfo.keySet()){
            registerPage.fillField(key, registrationInfo.get(key));
        }
        registerPage.putBirthday(registrationInfo.get("dayBirthday"), registrationInfo.get("monthBirthday"),
                registrationInfo.get("yearBirthday"));
        registerPage.selectGender(registrationInfo.get("gender"));
        registerPage.checkTermsConditions();
    }

    @And("^I try to save my data$")
    public void iTryToSaveMyData(){
        registerPage.saveData();
    }

    @And("I complete \"([^\"]*)\" with \"([^\"]*)\"")
    public void iCompleteWith(String field, String value) {
        homePage.fillField(field, value);
    }

    @Then("^I should see an error message \"([^\"]*)\"$")
    public void iShouldSeeAnErrorMessage(String errorMessae){
        assertThat("The message of missing phone number is missing",
                registerPage.getErrorMessage(), equalTo(errorMessae));
        homePage = null;
    }

    @Then("^I should be see \"([^\"]*)\" in the homepage$")
    public void iShouldBeSignedIn(String name){
        assertThat(String.format("The expected name is %s but was %s", name, homePage.getNameUserLogin()),
                homePage.getNameUserLogin() , equalTo(name));
    }

    @Then("^I should see a sign in error \"([^\"]*)\"$")
    public void iShouldSeeASignInError(String errorMessage){
        assertThat("The login error message was not found", homePage.getErrorMessageLogin(),
                equalTo(errorMessage));
    }

    @Then("^I should be signed out$")
    public void iShouldBeSignedOut(){
        assertThat("Log out was not successful", homePage.getTextMainPageLoginButton(),
                equalTo("Mi cuenta"));
    }
}
