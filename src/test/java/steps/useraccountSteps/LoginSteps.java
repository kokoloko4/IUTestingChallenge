package steps.useraccountSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import helpers.HelperUserAccount;

public class LoginSteps {

    @When("^I enter in login form$")
    public void IEnterInLoginForm(){
        HelperUserAccount.getLoginPage();
    }

    @And("^I click hover login button$")
    public void IClickHoverLoginButton(){
        HelperUserAccount.completeLoginForm();
    }
}
