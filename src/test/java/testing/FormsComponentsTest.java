package testing;

import Appiumconfigurations.AppiumDriverConfig;
import Appiumconfigurations.SwipeActions;
import Pages.FormsComponetPage;
import io.appium.java_client.AppiumDriver;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;

import java.io.File;


public class FormsComponentsTest {
    public static void main(String[] args) {
        AppiumDriver driver = AppiumDriverConfig.GetAppiumDriver();
        FormsComponetPage userPage = new FormsComponetPage(driver);
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

