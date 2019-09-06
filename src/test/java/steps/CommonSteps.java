package steps;

import cucumber.api.java.en.Given;
import helpers.PropertyHelper;
import junit.framework.TestCase;
import pages.HomePage;
import pages.ProductPage;

import static org.junit.Assert.assertTrue;

public class CommonSteps {

    static HomePage homePage = HomePage.getInstance();
    private static ProductPage productPage = ProductPage.getInstance();

    @Given("^I am in Falabella homepage$")
    public void iAmInFalabellaHomepage(){
        homePage.setPage(PropertyHelper.getUrl("homePageUrl"));
        assertTrue("Home page does not load",homePage.loadPage());
    }

    @Given("^I am in a product page$")
    public void iAmInAProductPage(){
        productPage.setPage(PropertyHelper.getUrl("productUrl"));
        TestCase.assertTrue("Product page did not load", productPage.loadPage());
    }
}
