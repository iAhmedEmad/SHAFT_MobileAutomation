package Pages;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage {
    SHAFT.GUI.WebDriver driver;

    public CheckoutInformationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    // Locators
    private By firstNameTextField = AppiumBy.accessibilityId("test-First Name");
    private By lastNameTextField = AppiumBy.accessibilityId("test-Last Name");
    private By zipCodeTextField = AppiumBy.accessibilityId("test-Zip/Postal Code");
    private By continueButton = AppiumBy.accessibilityId("test-CONTINUE");

    public By getContinueButton() {
        return continueButton;
    }

    // Actions
    public CheckoutInformationPage enterFirstName(String firstName){
        driver.element().type(firstNameTextField,firstName);
        return this;
    }
    public CheckoutInformationPage enterLastName(String lastName){
        driver.element().type(lastNameTextField,lastName);
        return this;
    }
    public CheckoutInformationPage enterZipCode(String zipCode){
        driver.element().type(zipCodeTextField,zipCode);
        return this;
    }
    public CheckoutOverviewPage clickContinue(){
        driver.element().click(continueButton);
        return new CheckoutOverviewPage(driver);
    }
    public CheckoutInformationPage ScrollDownToElement(By element){
        driver.element().scrollToElement(element);
        return this;
    }
}
