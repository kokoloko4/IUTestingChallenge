package steps.useraccountSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import helpers.HelperUserAccount;

public class RegisterSteps {

    @When("^I enter to register page$")
    public void IEnterToRegisterPage(){
        HelperUserAccount.getRegisterPage();
    }

    @When("^I complete birthday, day with \"([^\"]*)\", " +
            "month with \"([^\"]*)\", year with \"([^\"]*)\"$")
    public void setBirthday(String day, String month, String year){
        HelperUserAccount.setBirthday(day, month, year);
    }

    @And("^I try to save my data$")
    public void ITryToSaveMyData(){
        HelperUserAccount.completeRegisterForm();
    }
}
