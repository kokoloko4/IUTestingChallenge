package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.HelperUserAccount;

public class AccountSteps {

    @When("^I enter in login form$")
    public void IEnterInLoginForm(){
        HelperUserAccount.getLoginPage();
    }

    @When("^I enter to register page$")
    public void IEnterToRegisterPage(){
        HelperUserAccount.getRegisterPage();
    }

    @When("^I complete birthday, day with \"([^\"]*)\", " +
            "month with \"([^\"]*)\", year with \"([^\"]*)\"$")
    public void setBirthday(String day, String month, String year){
        HelperUserAccount.setBirthday(day, month, year);
    }

    @When("^I sign out$")
    public void ISignOut(){
        HelperUserAccount.logout();
    }

    @And("^I click hover login button$")
    public void IClickHoverLoginButton(){
        HelperUserAccount.completeLoginForm();
    }

    @And("^I complete \"([^\"]*)\" with \"([^\"]*)\" in \"([^\"]*)\"$")
    public void ICompleteField(String fieldName, String value, String page){
        if (page.equals("register") && fieldName.equals("gender")){
            HelperUserAccount.selectGender(value);
        } else {
            HelperUserAccount.completeField(fieldName, value, page);
        }
    }

    @And("^I check the terms and conditions$")
    public void ICheckTheTermsAndConditions(){
        HelperUserAccount.checkTermsConditions();
    }

    @And("^I try to save my data$")
    public void ITryToSaveMyData(){
        HelperUserAccount.completeRegisterForm();
    }

    @Then("^I should see an error message$")
    public void IShouldSeeAnErrorMessage(){
        HelperUserAccount.verifyThatPhoneIsMissing();
    }

    @Then("^I should be see \"([^\"]*)\" in the homepage$")
    public void IShouldBeSignedIn(String name){
        HelperUserAccount.verifyUserLogin(name);
    }

    @Then("^I should see a sign in error$")
    public void IShouldSeeASignInError(){
        HelperUserAccount.verifyErrorLogin();
    }

    @Then("^I should be signed out$")
    public void IShouldBeSignedOut(){
        HelperUserAccount.verifyUserIsLogout();
    }
}
