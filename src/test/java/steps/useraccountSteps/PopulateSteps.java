package steps.useraccountSteps;

import cucumber.api.java.en.And;
import utils.Helper;

public class PopulateSteps {

    @And("^I complete \"([^\"]*)\" with \"([^\"]*)\"")
    public void ICompleteField(String fieldName, String value){
        if (fieldName.equals("gender")) {
            Helper.selectGender(value);
        }else {
            Helper.completeField(fieldName, value);
        }
    }

}
