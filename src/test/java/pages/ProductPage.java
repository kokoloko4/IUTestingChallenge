package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//*[@class='fb-product-cta__title']")
    private WebElement productTitle;
    @FindBy(xpath = "//*[@class='fb-btn fb-btn-primary fb-product-cta__controls--actions--choose full-width-btn']")
    private WebElement addBagButton;
    @FindBy(xpath = "//*[@class='fb-masthead-basket__icon icon-bag-green']")
    private WebElement shoppingBagButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public Boolean loadPage(){
        if(productTitle.isDisplayed()){
            return true;
        }
        return false;
    }

    public void addProductToTheBag(){
        addBagButton.click();
        getWebDriverWait().until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@class='fb-overlay__inject']")));
    }

    public Boolean verifyProductIsInBag(){
        if(driver.findElement(By.xpath("//*[@id='fb-overlay']//*[@class='fb-added-to-basket__title']"))
                .getText().equals("Agregado")){
            return true;
        }
        return false;
    }

    public ShoppingPage clickHoverBag(){
        shoppingBagButton.click();
        return new ShoppingPage(driver);
    }

    public void closePopupAddBag(){
        driver.findElement(By.id("fb-overlay")).click();
    }

}
