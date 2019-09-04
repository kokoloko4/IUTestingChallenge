package helpers;

import org.openqa.selenium.WebDriver;
import pages.ShoppingPage;
import steps.Hooks;
import utils.ReadPropertiesFile;

import java.io.IOException;

import static junit.framework.TestCase.assertTrue;

public class HelperShoppingBag {

    private static final WebDriver driver = Hooks.driver;
    private static ShoppingPage shoppingPage = new ShoppingPage(driver);

    public static void getShoppingPage(){
        try {
            ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile();
            shoppingPage.setPage(readPropertiesFile.getShoppingBag());
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue("The shopping bag page did not load", shoppingPage.loadPage());
    }

    public static void deleteProduct(){
        shoppingPage.deleteProductFromShoppingBag();
    }

    public static void validateEmptyBag(){
        assertTrue("The product was not deleted", shoppingPage.isBagEmpty());
    }
}
