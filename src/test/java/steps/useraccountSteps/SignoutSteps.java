package steps.useraccountSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.HelperUserAccount;

public class SignoutSteps {

    @When("^I sign out$")
    public void ISignOut(){
        HelperUserAccount.logout();
    }

    @Then("^I should be signed out$")
    public void IShouldBeSignedOut(){
        HelperUserAccount.verifyUserIsLogout();
    }
}
