package steps.useraccountSteps;

import cucumber.api.java.en.And;
import helpers.HelperUserAccount;

public class PopulateSteps {

    @And("^I complete \"([^\"]*)\" with \"([^\"]*)\" in \"([^\"]*)\"$")
    public void ICompleteField(String fieldName, String value, String page){
        if (page.equals("register") && fieldName.equals("gender")){
            HelperUserAccount.selectGender(value);
        } else {
            HelperUserAccount.completeField(fieldName, value, page);
        }
    }

}
