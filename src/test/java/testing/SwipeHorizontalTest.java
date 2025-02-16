package testing;

import Appiumconfigurations.AppiumDriverConfig;
import Pages.SwipePage;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.Test;
import java.io.File;

@Story("Valid horizontal Swip")
public class SwipeHorizontalTest {
    @Test
    @Description("Verify user can move horizontally to elements")
    public void Swiping() throws InterruptedException {
        AndroidDriver driver = AppiumDriverConfig.GetAppiumDriver();
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

