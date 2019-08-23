package steps;

import cucumber.api.java.en.Given;
import utils.Helper;

public class CommonSteps {

    private Helper helper;

    public CommonSteps(){
        helper = new Helper();
    }

    @Given("^I am in Falabella homepage$")
    public void IAmInFalabellaHomepage(){
        helper.getHomePage();
    }
}
