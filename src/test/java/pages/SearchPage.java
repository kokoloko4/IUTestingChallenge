package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//*[@class='fb-masthead__breadcrumb__links']/a")
    private List<WebElement> breadCrumbLinks;
    @FindBy(xpath = "//*[@id='vertical-filters-custom']")
    private WebElement filterBar;
    @FindBy(xpath = "//*[@class='fb-filter_container'][5]//*[@class='fb-filter-list']" +
            "//*[@class='content-text-verticalFilter']")
    private List<WebElement> ranges;

    private By typesFilters = By.xpath("//*[@class='fb-filter_container']");
    private By filterProducts = By.xpath("//*[@id='all-pods']//*[@class='pod-item']");
    private By priceProduct = By.xpath("//*[@class='fb-price']");

    SearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSuccessfulSearch(String product){
        return breadCrumbLinks.get(1).getText().equals(" /  Resultados de la búsqueda \"" + product + "\"");
    }

    public void filterByPrice(String min, String max){
        filterBar.findElements(typesFilters).get(5).click();
        int cont = 0;
        WebElement filter = null;
        while(cont < ranges.size() && filter == null){
            if(ranges.get(cont).findElement(By.xpath(".//input")).getAttribute("name").equals("$"+min+" - $"+max)){
                filter = ranges.get(cont).findElement(By.xpath(".//label"));
            }
            cont++;
        }
        filter.click();
        getWebDriverWait();
    }

    public boolean arePricesCorrect(int min, int max){
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
