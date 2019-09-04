package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingPage extends BasePage {

    @FindBy(xpath = "//*[@class='fb-product__action-list__item fb-product__action-list__item--delete"+
            " js-product__action-list--delete']")
    private WebElement deleteButton;

    private By titleShoppingBagPage = By.xpath("//*[@class='fb-order-status__title']");
    private By productInShoppingBag = By.xpath("//*[@class='fb-product-item__container  " +
            "fb-product-item--has-notification ']");
    private By textEmptyBag = By.xpath("//*[@class='fb-order-status__empty-basket']");

    public ShoppingPage(WebDriver driver) {
        super(driver);
    }

    public boolean loadPage(){
        return driver.findElement(titleShoppingBagPage).getText().equals("Bolsa de Compras");
    }

    public void deleteProductFromShoppingBag(){
        deleteButton.click();
        getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(productInShoppingBag));
    }

    public boolean isBagEmpty(){
        return driver.findElement(textEmptyBag).getText().equals("Tu Bolsa de Compras está vacía. " +
                "Agrega productos ahora>>\nSeguir comprando");
    }
}
