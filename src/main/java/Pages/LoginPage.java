package Pages;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    SHAFT.GUI.WebDriver driver;
    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By userNameTextField = AppiumBy.accessibilityId("test-Username");
    private By passwordTextField = AppiumBy.accessibilityId("test-Password");
    private By loginButton = AppiumBy.accessibilityId("test-LOGIN");
    private By errorMessage = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView");

    public By getErrorMessage() {
        return errorMessage;
    }
    // Actions
    public LoginPage entreEmail(String email){
        driver.element().type(userNameTextField,email);
        return this;
    }
    public LoginPage entrePassword(String password){
        driver.element().type(passwordTextField,password);
        return this;
    }
    public ProductsPage clickOnLogin(){
        driver.element().click(loginButton);
        return new ProductsPage(driver);
    }
    public ProductsPage userLogin(String email, String password){
        entreEmail(email);
        entrePassword(password);
        clickOnLogin();
        return new ProductsPage(driver);
    }

}
