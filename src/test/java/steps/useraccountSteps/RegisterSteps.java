package steps.useraccountSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import utils.Helper;

public class RegisterSteps {

    @When("^I enter to register page$")
    public void IEnterToRegisterPage(){
        Helper.getRegisterPage();
    }

    @When("^I complete birthday, day with \"([^\"]*)\", " +
            "month with \"([^\"]*)\", year with \"([^\"]*)\"$")
    public void setBirthday(String day, String month, String year){
        Helper.setBirthday(day, month, year);
    }

    @And("^I try to save my data$")
    public void ITryToSaveMyData(){
        Helper.completeForm();
    }
}
