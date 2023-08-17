package Pages;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    SHAFT.GUI.WebDriver driver;
    public CartPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By itemNameOnCartPage = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]");
    private By itemPriceOnCartPage = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\\\"test-Price\\\"]/android.widget.TextView");
    private By removeItemButton = AppiumBy.accessibilityId("test-REMOVE");
    private By checkoutButton = AppiumBy.accessibilityId("test-CHECKOUT");
    private By ProductQTYOnCartPage = AppiumBy.xpath("AppiumBy.xpath(\"//android.view.ViewGroup[@content-desc=\\\"test-Amount\\\"]/android.widget.TextView\")");

    public By getProductQTYOnCartPage() {
        return ProductQTYOnCartPage;
    }

    // Actions
    public void removeItemFromCart(){
        driver.element().click(removeItemButton);
    }
    public CheckoutInformationPage clickOnCheckoutButton(){
        driver.element().click(checkoutButton);
        return new CheckoutInformationPage(driver);
    }
}
