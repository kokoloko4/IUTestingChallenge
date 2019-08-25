package steps.useraccountSteps;

import cucumber.api.java.en.Then;
import helpers.HelperUserAccount;

public class SigninSteps {

    @Then("^I should be see \"([^\"]*)\" in the homepage$")
    public void IShouldBeSignedIn(String name){
        HelperUserAccount.verifyUserLogin(name);
    }

    @Then("^I should see a sign in error$")
    public void IShouldSeeASignInError(){
        HelperUserAccount.verifyErrorLogin();
    }
}
