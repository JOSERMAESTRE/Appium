import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class LaunchApp {
    public static void main(String[] args) {
        AppiumDriver driver;
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("appium:appPackage", "com.wdiodemoapp");
            capabilities.setCapability("appium:appActivity", ".MainActivity");
            capabilities.setCapability("appium:udid", "emulator-5554");
            capabilities.setCapability("appium:automationName", "UiAutomator2");
            capabilities.setCapability("platformName", "Android");

            // Nueva URL para Appium 2.0
            URL AppiumServer = new URL("http://localhost:4723");

            driver = new AppiumDriver(AppiumServer, capabilities);
            System.out.println("Sesión iniciada correctamente");
        } catch (Exception e) {
            System.out.println("Error al iniciar la sesión:");
            e.printStackTrace();
        }
    }
}