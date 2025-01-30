package testing;

import Appiumconfigurations.AppiumDriverConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class SetValues {
    public static void main(String[] args){
        AppiumDriver driver = AppiumDriverConfig.GetAppiumDriver();
        WebElement LoginLabel = driver.findElement(AppiumBy.accessibilityId("Login"));
        LoginLabel.click();
        WebElement UserNameLabel = driver.findElement(AppiumBy.accessibilityId("input-email"));
        UserNameLabel.sendKeys("test@test.com");
        WebElement PasswordLabel = driver.findElement(AppiumBy.accessibilityId("input-password"));
        PasswordLabel.sendKeys("test@test.com");
        WebElement LoginButton = driver.findElement(AppiumBy.accessibilityId("button-LOGIN"));
        LoginButton.click();
    }
}
