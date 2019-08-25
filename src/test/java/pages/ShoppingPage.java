package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingPage extends BaseShoppingBagPage {

    @FindBy(xpath = "//*[@class='fb-product__action-list__item fb-product__action-list__item--delete"+
            " js-product__action-list--delete']")
    private WebElement deleteButton;

    public ShoppingPage(WebDriver driver) {
        super(driver);
    }

    public Boolean verifyThePageLoad(){
        if(driver.findElement(By.xpath("//*[@class='fb-order-status__title']")).getText().equals("Bolsa de Compras")){
            return true;
        }
        return false;
    }

    public void deleteProductFromShoppingBag(){
        deleteButton.click();
        getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
                "//*[@class='fb-product-item__container  fb-product-item--has-notification ']"
        )));
    }

    public Boolean verifyBagIsEmpty(){
        if(driver.findElement(By.xpath("//*[@class='fb-order-status__empty-basket']")).getText().equals(
                "Tu Bolsa de Compras está vacía. Agrega productos ahora>>\nSeguir comprando")){
            return true;
        }
        return false;
    }

    private WebDriverWait getWebDriverWait(){
        return new WebDriverWait(driver, 3);
    }
}
