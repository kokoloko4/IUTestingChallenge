package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import steps.Hooks;

public class ProductPage extends BasePage {

    private static ProductPage instance;

    @FindBy(xpath = "//*[@class='fb-product-cta__title']")
    private WebElement productTitle;
    @FindBy(xpath = "//*[@class='fb-btn fb-btn-primary fb-product-cta__controls--actions--choose full-width-btn']")
    private WebElement addBagButton;

    private By addedProductPopup = By.xpath("//*[@class='fb-overlay__inject']");
    private By textAddedProductPopup = By.xpath("//*[@id='fb-overlay']//*[@class='fb-added-to-basket__title']");

    private ProductPage(WebDriver driver) {
        super(driver);
    }

    public static ProductPage getInstance() {
        if (instance == null) {
            instance = new ProductPage(Hooks.driver);
        }
        return instance;
    }

    public Boolean loadPage(){
        return productTitle.isDisplayed();
    }

    public void addProductToTheBag(){
        addBagButton.click();
        getWebDriverWait().until(ExpectedConditions
                .visibilityOfElementLocated(addedProductPopup));
    }

    public boolean isTheProductAdded(){
        return driver.findElement(textAddedProductPopup).getText().equals("Agregado");
    }
}
