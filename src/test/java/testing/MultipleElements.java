package testing;

import Appiumconfigurations.AppiumDriverConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MultipleElements {
    public static void main(String[] args) {
        AppiumDriver driver = AppiumDriverConfig.GetAppiumDriver();
        WebElement LoginLabel = driver.findElement(AppiumBy.accessibilityId("Login"));
        LoginLabel.click();

        List<WebElement> LoginTextElements = driver.findElements(AppiumBy.xpath("//*[@text='Login']"));
        System.out.println("Number of element matched by XPATH search: "+LoginTextElements.size());


    }
}
