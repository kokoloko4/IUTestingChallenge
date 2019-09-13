package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.TestCase;
import pages.ProductPage;
import pages.ShoppingPage;
import utils.PageUrls;

import static junit.framework.TestCase.assertTrue;

public class ShoppingBagSteps {

    private static ProductPage productPage;
    private static ShoppingPage shoppingPage;

    public ShoppingBagSteps() {
        productPage = new ProductPage();
        shoppingPage = new ShoppingPage();
    }

    @Given("^I am in a product page$")
    public void iAmInAProductPage(){
        productPage.openPage(PageUrls.getProductPageUrl());
        TestCase.assertTrue("Product page did not load", productPage.isPageLoaded());
    }

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
        productPage.openPage(PageUrls.getShoppingBagPageUrl());
        assertTrue("The shopping bag page did not load", shoppingPage.isPageLoaded());
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
