package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//*[@id='vertical-filters-custom']")
    private WebElement filterBar;
    @FindBy(xpath = "//div[contains(text(),'Precio')]")
    private WebElement priceFilter;

    private By filterProducts = By.xpath("//*[@id='all-pods']//*[@class='pod-item']");
    private By priceProduct = By.xpath("//*[@class='fb-price']");

    private String specPriceXpath = ".//input[@name='$%s - $%s']/../label";

    public SearchPage() {
        super();
    }

    @Override
    public boolean isPageLoaded() {
        return false;
    }

    /**
     * @param min The minimum price for the filter
     * @param max The maximum price for the filter
     */
    public void filterByPrice(String min, String max){
        getWebDriverWait();
        priceFilter.click();
        filterBar.findElement(By.xpath(String.format(specPriceXpath, min, max))).click();
        getWebDriverWait();
    }

    /**
     * @param min The minimum price for the filter
     * @param max The maximum price for the filter
     * @return True if the prices meet the range of prices that was selected, false is not.
     */
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
