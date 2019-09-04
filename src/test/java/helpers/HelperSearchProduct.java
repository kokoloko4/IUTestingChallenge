package helpers;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.SearchPage;
import steps.Hooks;

import static org.junit.Assert.assertTrue;

public class HelperSearchProduct {

    private static final WebDriver driver = Hooks.driver;
    private static HomePage homePage = new HomePage(driver);

    private static SearchPage searchPage;
    private static int maxPrice;
    private static int minPrice;

    public static void findProduct(String productName){
        searchPage = homePage.findProduct(productName);
        assertTrue("The search was not successful", searchPage.isSuccessfulSearch(productName));
    }

    public static void filterProducts(String min, String max){
        maxPrice = Integer.parseInt(max.replace(".", ""));
        minPrice = Integer.parseInt(min.replace(".", ""));
        searchPage.filterByPrice(min, max);
    }

    public static void verifyProductsPrices(){
        assertTrue("A product is not in range",
                searchPage.arePricesCorrect(minPrice, maxPrice));
    }
}
