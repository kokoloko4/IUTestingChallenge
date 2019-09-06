package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import steps.Hooks;

import javax.xml.transform.sax.SAXSource;
import java.util.List;

public class SearchPage extends BasePage {

    private static SearchPage instance;

    @FindBy(xpath = "//*[@class='fb-masthead__breadcrumb__links']/a")
    private List<WebElement> breadCrumbLinks;
    @FindBy(xpath = "//*[@id='vertical-filters-custom']")
    private WebElement filterBar;

    private By typesFilters = By.xpath("//*[@class='fb-filter_container']");
    private By filterProducts = By.xpath("//*[@id='all-pods']//*[@class='pod-item']");
    private By priceProduct = By.xpath("//*[@class='fb-price']");

    private String specPriceXpath = ".//input[@name='$%s - $%s']/../label";

    SearchPage(WebDriver driver) {
        super(driver);
    }

    public static SearchPage getInstance() {
        if (instance == null) {
            instance = new SearchPage(Hooks.driver);
        }
        return instance;
    }

    public boolean isSuccessfulSearch(String product){
        getWebDriverWait();
        return breadCrumbLinks.get(1).getText().equals(" /  Resultados de la búsqueda \"" + product + "\"");
    }

    public void filterByPrice(String min, String max){
        filterBar.findElements(typesFilters).get(5).click();
        filterBar.findElement(By.xpath(String.format(specPriceXpath, min, max))).click();
        getWebDriverWait();
    }

    public boolean arePricesCorrect(int min, int max){
        getWebDriverWait();
        List<WebElement> foundProducts = driver.findElements(filterProducts);
        int cont = 0;
        boolean isInRange = true;
        while(cont < foundProducts.size() && isInRange){
            int productPrice = Integer.parseInt(foundProducts.get(cont).findElement(priceProduct)
                    .getText().split(" ")[1].replace(".",""));
            if(productPrice < min || productPrice > max){
                isInRange = false;
            }
            cont++;
        }
        return isInRange;
    }
}
