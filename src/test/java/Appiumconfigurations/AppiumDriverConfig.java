package Appiumconfigurations;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriverConfig {

    public static AppiumDriver GetAppiumDriver() {
        AppiumDriver driver = null;
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(CapabilitiesConfig.APP_PACKAGE, "com.wdiodemoapp");
            capabilities.setCapability(CapabilitiesConfig.APP_ACTIVITY, ".MainActivity");
            capabilities.setCapability(CapabilitiesConfig.DEVICE_ID, "emulator-5554");
            capabilities.setCapability(CapabilitiesConfig.AUTOMATION_NAME, "UiAutomator2");
            capabilities.setCapability(CapabilitiesConfig.PLATFORM_NAME, "Android");

            URL AppiumServer = new URL("http://localhost:4723");

            driver = new AppiumDriver(AppiumServer, capabilities);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("Error al iniciar la sesión:");
            e.printStackTrace();
        }
        return driver;
    }
}


