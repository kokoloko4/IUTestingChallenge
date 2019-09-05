package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.HelperSearchProduct;

public class FilterSteps {

    @And("^I search for \"([^\"]*)\"$")
    public void ISearchForWord(String word){
        HelperSearchProduct.findProduct(word);
    }

    @When("^I apply the filter for price between \"([^\"]*)\" and \"([^\"]*)\"$")
    public void IApplyTheFilterForPrice(String minimum, String maximum){
        HelperSearchProduct.filterProducts(minimum, maximum);
    }

    @Then("^I should see just products with prices in this range$")
    public void IShouldSeeProductsInRange(){
        HelperSearchProduct.verifyProductsPrices();
    }
}
