package steps.useraccountSteps;

import cucumber.api.java.en.Then;
import helpers.HelperUserAccount;

import static org.junit.Assert.assertThat;

public class SaveRegistrySteps {

    @Then("^I should see an error message$")
    public void IShouldSeeAnErrorMessage(){
        HelperUserAccount.verifyThatPhoneIsMissing();
    }
}
