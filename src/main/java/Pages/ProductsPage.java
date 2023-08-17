package Pages;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    SHAFT.GUI.WebDriver driver;

    public ProductsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By productsLabel = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Toggle']//parent::android.view.ViewGroup/android.widget.TextView");
    private By addToCartButton = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]");
    private By cartlogo = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView");
    private By itemNameOnProductPage = AppiumBy.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]");
    private By itemPriceOnProductPage = AppiumBy.xpath("(//android.widget.TextView[@content-desc=\"test-Price\"])[1]");
    public By getItemNameOnProductPage() {
        return itemNameOnProductPage;
    }

    public By getItemPriceOnProductPage() {
        return itemPriceOnProductPage;
    }
    public By getProductsLabel() {
        return productsLabel;
    }

    // Actions
    public ProductsPage clickAddToCart(){
        driver.element().click(addToCartButton);
        return this;
    }
    public CartPage clickCartLogo(){
        driver.element().click(cartlogo);
        return new CartPage(driver);
    }


}
