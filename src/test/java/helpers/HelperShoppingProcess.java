package helpers;

import org.openqa.selenium.WebDriver;
import pages.ProductPage;
import pages.ShoppingPage;
import steps.Hooks;
import utils.ReadPropertiesFile;

import java.io.IOException;

import static junit.framework.TestCase.assertTrue;

public class HelperShoppingProcess {

    private static final WebDriver driver = Hooks.driver;
    private static ProductPage productPage = new ProductPage(driver);
    private static ShoppingPage shoppingPage;

    public static void getProductPage(){
        try {
            ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile();
            productPage.setPage(readPropertiesFile.getProductUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue("Product page did not load", productPage.loadPage());
    }

    public static void addProductToTheShoppingBag(){
        productPage.addProductToTheBag();
    }

    public static void verifyProduct(){
        assertTrue("The product was not added to the shopping bag", productPage.verifyProductIsInBag());
    }
}
