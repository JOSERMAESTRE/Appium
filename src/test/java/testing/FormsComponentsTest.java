package testing;

import Appiumconfigurations.AppiumDriverConfig;
import Appiumconfigurations.SwipeActions;
import Pages.FormsComponentPage;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.Test;
import java.io.File;

@Story("Valid Form Components")
public class FormsComponentsTest {
    @Test
    @Description("Verify form components")
    public void FormsInteractions() {
        AndroidDriver driver = AppiumDriverConfig.GetAppiumDriver();
        FormsComponentPage userPage = new FormsComponentPage(driver);
        userPage.FormActions("Jose R Maestre");

        SwipeActions SwipeActions = new SwipeActions(driver);
        SwipeActions.swipeUp();

        File FormScreenshot = driver.getScreenshotAs(OutputType.FILE);
        String FormScreen = System.getProperty("user.dir") + "\\src\\test\\resources\\FormScreenshot.png";

        try {
            FileUtils.copyFile(FormScreenshot, new File(FormScreen));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

