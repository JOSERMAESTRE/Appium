package testing;

import Appiumconfigurations.AppiumDriverConfig;
import Appiumconfigurations.SwipeActions;
import Pages.FormsComponentPage;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;

import java.io.File;


public class FormsComponentsTest {
    public static void main(String[] args) {
        AndroidDriver driver = AppiumDriverConfig.GetAppiumDriver();
        FormsComponentPage userPage = new FormsComponentPage(driver);
        userPage.FormActions("Jose R Maeste");

        SwipeActions SwipeActions = new SwipeActions(driver);
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

