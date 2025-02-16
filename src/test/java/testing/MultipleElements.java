package testing;

import Appiumconfigurations.AppiumDriverConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class MultipleElements {
    public static void main(String[] args) {
        AndroidDriver driver = AppiumDriverConfig.GetAppiumDriver();
        WebElement LoginLabel = driver.findElement(AppiumBy.accessibilityId("Login"));
        LoginLabel.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBe(AppiumBy.xpath("//*[@text='Login']"), 2));
        List<WebElement> LoginTextElements = driver.findElements(AppiumBy.xpath("//*[@text='Login']"));
        System.out.println("Number of element matched by XPATH search: " + LoginTextElements.size());


    }
}
