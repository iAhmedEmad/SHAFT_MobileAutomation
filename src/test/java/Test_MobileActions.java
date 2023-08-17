import Pages.*;
import Utils.JsonFileManager;
import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Test_MobileActions {
    JsonFileManager testData = new JsonFileManager("src//test//resources//TestDataFiles//TestData.json");
    SHAFT.GUI.WebDriver driver;
    @BeforeMethod(description = "setup")
    public void setup() throws MalformedURLException {
        driver = new TestConfigurations(driver).setupDevice();
    }
    @AfterMethod(description = "Tear Down")
    public void tearDown() {
        new TestConfigurations(driver).tearDownDevice();
    }

    @Test
    //Login with Valid Email and password and validate that login is performed successfully
    public void testLoginSuccessfully(){
        new LoginPage(driver)
                .userLogin(testData.getTestData("userName"),testData.getTestData("password"));
        driver.assertThat().element(new ProductsPage(driver).getProductsLabel()).text().isEqualTo(testData.getTestData("productsLabel")).perform();
    }
    @Test
    //Login with invalid email or password
    public void testInvalidLogin(){
        new LoginPage(driver)
                .userLogin(testData.getTestData("userName"),testData.getTestData("invalidPassword"));
        driver.assertThat().element(new LoginPage(driver).getErrorMessage()).text().isEqualTo(testData.getTestData("errorMessage")).perform();
    }
    @Test
    //Add Any Item to the cart and validate that Title and price of the Item at Home page equals the item and price at the cart
    public void testAddToCart(){
            new LoginPage(driver)
                    .userLogin(testData.getTestData("userName"),testData.getTestData("password"))
                    .clickAddToCart()
                    .clickCartLogo();
        driver.assertThat().element(new ProductsPage(driver).getItemNameOnProductPage()).text().isEqualTo(testData.getTestData("productName")).perform();
        driver.assertThat().element(new ProductsPage(driver).getItemPriceOnProductPage()).text().isEqualTo(testData.getTestData("productPrice")).perform();
    }
    @Test
    //Validate Removing Items from the cart and validate that the cart is empty
    public void testRemovingItemFromCart(){
        new LoginPage(driver)
                .userLogin(testData.getTestData("userName"),testData.getTestData("password"))
                .clickAddToCart()
                .clickCartLogo()
                .removeItemFromCart();
        driver.assertThat().element(new CartPage(driver).getProductQTYOnCartPage()).doesNotExist().perform();
    }
    @Test
    //Online Ordering and complete the flow from adding element to cart till the checkout, Also Validate the price and success purchase.
    public void testCompleteOrdering(){
        new LoginPage(driver)
                .userLogin(testData.getTestData("userName"),testData.getTestData("password"))
                .clickAddToCart()
                .clickCartLogo()
                .clickOnCheckoutButton()
                .enterFirstName(testData.getTestData("firstName"))
                .enterLastName(testData.getTestData("lastName"))
                .enterZipCode(testData.getTestData("zipCode"))
                .ScrollDownToElement(new CheckoutInformationPage(driver).getContinueButton())
                .clickContinue();
    driver.assertThat().element(new CheckoutOverviewPage(driver).getItemPriceOnCheckoutOverviewPage()).text().isEqualTo(testData.getTestData("productPrice")).perform();
    new CheckoutOverviewPage(driver)
            .ScrollDownToSpecificText()
            .clickOnFinish();
    driver.assertThat().element(new CheckoutCompletePage(driver).getSuccessfulPurchaseMessage()).text().isEqualTo(testData.getTestData("successfullPurchaseMessage")).perform();
    }














}
