package steps;

import cucumber.api.java.en.Given;
import pages.HomePage;

public class CommonSteps {

    @Given("^I am in Falabella homepage$")
    public void IAmInFalabellaHomepage(){
        HomePage homePage = new HomePage(RunnerHelper.driver);
    }
}
