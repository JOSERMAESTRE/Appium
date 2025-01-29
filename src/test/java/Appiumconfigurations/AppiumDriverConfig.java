package Appiumconfigurations;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriverConfig {

    public static AppiumDriver GetAppiumDriver() {
        AppiumDriver driver = null;
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("appium:appPackage", "com.wdiodemoapp");
            capabilities.setCapability("appium:appActivity", ".MainActivity");
            capabilities.setCapability("appium:udid", "emulator-5554");
            capabilities.setCapability("appium:automationName", "UiAutomator2");
            capabilities.setCapability("platformName", "Android");

            URL AppiumServer = new URL("http://localhost:4723");

            driver = new AppiumDriver(AppiumServer, capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("Error al iniciar la sesión:");
            e.printStackTrace();
        }
        return driver;
    }
}


