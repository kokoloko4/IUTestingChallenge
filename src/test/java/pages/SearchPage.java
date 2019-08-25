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

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public Boolean verifySearchProductPage(String product){
        if(breadCrumbLinks.get(1).getText().equals(" /  Resultados de la búsqueda \"" + product + "\"")){
            return true;
        }
        return false;
    }

    public void filterByPrice(String min, String max){
        List<WebElement> filters = filterBar.findElements(By.xpath("//*[@class='fb-filter_container']"));
        filters.get(5).click();
        List<WebElement> ranges = driver.findElements(By.xpath(
                "//*[@class='fb-filter_container'][5]//*[@class='fb-filter-list']" +
                        "//*[@class='content-text-verticalFilter']"));
        int cont = 0;
        WebElement filter = null;
        while(cont < ranges.size() && filter == null){
            if(ranges.get(cont).findElement(By.xpath(".//input")).getAttribute("name").equals("$"+min+" - $"+max)){
                filter = ranges.get(cont).findElement(By.xpath(".//label"));
            }
            cont++;
        }
        filter.click();
    }

    public Boolean verifyProductsPrices(int min, int max){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        List<WebElement> morePages = driver.findElements(By.xpath("//*[@class='icon-right']"));
        webDriverWait.until(ExpectedConditions.invisibilityOfAllElements(morePages));
        List<WebElement> foundProducts = driver.findElements(By.xpath("//*[@id='all-pods']//*[@class='pod-item']"));
        int cont = 0;
        boolean isInRange = true;
        while(cont < foundProducts.size() && isInRange){
            int productPrice = Integer.parseInt(foundProducts.get(cont).findElement(By.xpath("//*[@class='fb-price']"))
                    .getText().split(" ")[1].replace(".",""));
            if(productPrice < min || productPrice > max){
                isInRange = false;
            }
            cont++;
        }
        return isInRange;
    }
}
