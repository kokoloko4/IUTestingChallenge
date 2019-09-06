package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.PropertyHelper;
import pages.ProductPage;
import pages.ShoppingPage;

import static junit.framework.TestCase.assertTrue;

public class ShoppingBagSteps {

    private static ProductPage productPage = ProductPage.getInstance();
    private static ShoppingPage shoppingPage = ShoppingPage.getInstance();

    @When("^I add the product to the bag$")
    public void iAddTheProductToTheBag(){
        productPage.addProductToTheBag();
    }

    @Then("^I should see a pop up with the confirmation$")
    public void iShouldSeeAPopUpWithTheConfirmation(){
        assertTrue("The product was not added to the shopping bag", productPage.isTheProductAdded());
    }

    @When("^I have a product in my shopping bag$")
    public void iHaveAProductInMyShoppingBag(){
        iAddTheProductToTheBag();
        productPage.setPage(PropertyHelper.getUrl("shoppingBagUrl"));
        assertTrue("The shopping bag page did not load", shoppingPage.loadPage());
    }

    @When("^I delete the product$")
    public void iDeleteTheProduct(){
        shoppingPage.deleteProductFromShoppingBag();
    }

    @Then("^I should see a message saying that my bag is empty$")
    public void iShouldSeeAMessageSayingThatMyBagIsEmpty(){
        assertTrue("The product was not deleted", shoppingPage.isBagEmpty());
    }
}
