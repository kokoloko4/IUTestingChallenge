package steps;

import cucumber.api.java.en.Given;
import helpers.HelperShoppingProcess;
import helpers.HelperUserAccount;

public class CommonSteps {

    @Given("^I am in Falabella homepage$")
    public void IAmInFalabellaHomepage(){
        HelperUserAccount.getHomePage();
    }

    @Given("^I am in a product page$")
    public void IAmInAProductPage(){
        HelperShoppingProcess.getProductPage();
    }
}
