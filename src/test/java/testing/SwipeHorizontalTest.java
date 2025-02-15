package testing;

import Appiumconfigurations.AppiumDriverConfig;
import Pages.SwipePage;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;

import static java.time.Duration.ofSeconds;

public class SwipeHorizontalTest {
    public static void main(String[] args) throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.GetAppiumDriver();
        SwipePage swipePage = new SwipePage(driver);
        swipePage.swipeLeft("EXTENDABLE");

        File FormScreenshot = driver.getScreenshotAs(OutputType.FILE);
        String FormScreen = System.getProperty("user.dir") + "\\src\\test\\resources\\SwipeScreenshot.png";

        try {
            FileUtils.copyFile(FormScreenshot, new File(FormScreen));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}

