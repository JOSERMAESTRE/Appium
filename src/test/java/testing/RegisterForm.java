package testing;

import Appiumconfigurations.AppiumDriverConfig;
import Appiumconfigurations.SwipeActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;


public class RegisterForm {
    public static void main(String[] args) {
        AppiumDriver driver = AppiumDriverConfig.GetAppiumDriver();
        WebElement formsLabel = driver.findElement(AppiumBy.accessibilityId("Forms"));
        formsLabel.click();
        WebElement inputField = driver.findElement(AppiumBy.accessibilityId("text-input"));
        inputField.sendKeys("Jose R Maestre");

        WebElement switchText = driver.findElement(AppiumBy.accessibilityId("switch-text"));
        System.out.println(switchText.getText());
        WebElement switchButton = driver.findElement(AppiumBy.accessibilityId("switch"));
        switchButton.click();
        System.out.println(switchText.getText());

        SwipeActions SwipeActions = new SwipeActions(driver);
        SwipeActions.swipeBottom();

        WebElement Dropdown = driver.findElement(AppiumBy.accessibilityId("Dropdown"));
        Dropdown.click();

        WebElement FirstOne = driver.findElement(AppiumBy.xpath("//*[@text='webdriver.io is awesome']"));
        FirstOne.click();

        SwipeActions.swipeUp();

        File FormScreenshot = driver.getScreenshotAs(OutputType.FILE);
        String FormScreen = System.getProperty("user.dir") + "\\src\\test\\resources\\Formscreenshot.png";

        try {
            FileUtils.copyFile(FormScreenshot, new File(FormScreen));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

