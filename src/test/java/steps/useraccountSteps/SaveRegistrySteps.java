package steps.useraccountSteps;

import cucumber.api.java.en.Then;
import steps.RunnerHelper;
import pages.RegisterPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SaveRegistrySteps {

    private RegisterPage registerPage;

    public SaveRegistrySteps(){
        registerPage = new RegisterPage(RunnerHelper.driver);
    }

    @Then("^I should see an error message$")
    public void IShouldSeeAnErrorMessage(){
        assertThat("Error mensaje", registerPage.getErrorMessage(),equalTo("Debes ingresar un celular"));
    }
}
