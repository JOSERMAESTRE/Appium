import Appiumconfigurations.AppiumDriverConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;


public class LaunchApp {
    public static void main(String[] args) {
            AppiumDriver driver = AppiumDriverConfig.GetAppiumDriver();
            WebElement LoginLabel = driver.findElement(AppiumBy.accessibilityId("Login"));
            LoginLabel.click();
    }
}