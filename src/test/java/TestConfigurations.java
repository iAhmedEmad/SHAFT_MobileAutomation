import com.shaft.driver.SHAFT;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class TestConfigurations {
    SHAFT.GUI.WebDriver driver;
    public TestConfigurations(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public SHAFT.GUI.WebDriver setupDevice() throws MalformedURLException {
            SHAFT.Properties.platform.set().executionAddress("localhost:4723");
            SHAFT.Properties.platform.set().targetPlatform("Android");
            SHAFT.Properties.mobile.set().app(SHAFT.Properties.paths.testData()+"Android.SauceLabs.Mobile.Sample.app.2.2.0.apk");
            SHAFT.Properties.mobile.set().deviceName("Demo");
            SHAFT.Properties.mobile.set().platformVersion("14.0");
            SHAFT.Properties.mobile.set().automationName("UiAutomator2");
            driver = new SHAFT.GUI.WebDriver();
            return driver;
        }
    public void tearDownDevice() {
        if (driver != null) {
            driver.quit();
        }
    }
}
