package Pages;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
    SHAFT.GUI.WebDriver driver;

    public CheckoutOverviewPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By finishButton = AppiumBy.accessibilityId("test-FINISH");
    private By itemPriceOnCheckoutOverviewPage = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView)[1]");
    public By getItemPriceOnCheckoutOverviewPage() {
        return itemPriceOnCheckoutOverviewPage;
    }
    // Actions
    public CheckoutCompletePage clickOnFinish(){
        driver.element().click(finishButton);
        return new CheckoutCompletePage(driver);
    }
    public CheckoutOverviewPage ScrollDownToSpecificText(){
        driver.element().scrollToElement(finishButton);
        return this;
    }
}
