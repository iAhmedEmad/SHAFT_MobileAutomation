package Pages;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
    SHAFT.GUI.WebDriver driver;

    public CheckoutCompletePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public By getSuccessfulPurchaseMessage() {
        return successfulPurchaseMessage;
    }

    // Locators
    private By successfulPurchaseMessage = AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]");

    // Actions
}
