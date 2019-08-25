package steps.shoppingprocessSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.HelperShoppingBag;
import helpers.HelperShoppingProcess;

public class ShoppingBagSteps {

    @When("^I add the product to the bag$")
    public void IAddTheProductToTheBag(){
        HelperShoppingProcess.addProductToTheShoppingBag();
    }

    @Then("^I should see a pop up with the confirmation$")
    public void IShouldSeeAPopUpWithTheConfirmation(){
        HelperShoppingProcess.verifyProduct();
    }

    @When("^I have a product in my shopping bag$")
    public void IHaveAProductInMyShoppingBag(){
        HelperShoppingProcess.addProductToTheShoppingBag();
        HelperShoppingBag.getShoppingPage();
    }

    @When("^I delete the product$")
    public void IDeleteTheProduct(){
        HelperShoppingBag.deleteProduct();
    }

    @Then("^I should see a message saying that my bag is empty$")
    public void IShouldSeeAMessageSayingThatMyBagIsEmpty(){
        HelperShoppingBag.validateEmptyBag();
    }
}
