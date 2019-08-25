package helpers;

import org.openqa.selenium.WebDriver;
import pages.ShoppingPage;
import steps.RunnerHelper;

import static junit.framework.TestCase.assertTrue;

public class HelperShoppingBag {

    private static final WebDriver driver = RunnerHelper.driver;
    private static ShoppingPage shoppingPage = new ShoppingPage(driver);

    public static void getShoppingPage(){
        assertTrue("The shopping bag page did not load", shoppingPage.verifyThePageLoad());
    }

    public static void deleteProduct(){
        shoppingPage.deleteProductFromShoppingBag();
    }

    public static void validateEmptyBag(){
        assertTrue("The product was not deleted", shoppingPage.verifyBagIsEmpty());
    }
}
