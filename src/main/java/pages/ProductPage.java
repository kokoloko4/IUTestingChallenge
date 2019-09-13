package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//*[@class='fb-product-cta__title']")
    private WebElement productTitle;
    @FindBy(xpath = "//*[@class='fb-btn fb-btn-primary fb-product-cta__controls--actions--choose full-width-btn']")
    private WebElement addBagButton;

    private By addedProductPopup = By.xpath("//*[@class='fb-overlay__inject']");
    private By textAddedProductPopup = By.xpath("//*[@id='fb-overlay']//*[@class='fb-added-to-basket__title']");

    public ProductPage() {
        super();
    }

    @Override
    public boolean isPageLoaded() {
        return productTitle.isDisplayed();
    }

    /**
     * When the user wants to add a product into the shopping bag
     */
    public void addProductToTheBag(){
        addBagButton.click();
        getWebDriverWait().until(ExpectedConditions
                .visibilityOfElementLocated(addedProductPopup));
    }

    /**
     * @return Verify is the product was added to the shopping bag
     */
    public boolean isTheProductAdded(){
        return driver.findElement(textAddedProductPopup).getText().equals("Agregado");
    }
}
