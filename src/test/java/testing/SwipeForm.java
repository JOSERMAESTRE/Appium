package testing;

import Appiumconfigurations.AppiumDriverConfig;
import Appiumconfigurations.SwipeActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;

public class SwipeForm {
    public static void main(String[] args) {
        AppiumDriver driver = AppiumDriverConfig.GetAppiumDriver();
        WebElement SwipeLabel = driver.findElement(AppiumBy.accessibilityId("Swipe"));
        SwipeLabel.click();

        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.xpath("//*[@text='Swipe horizontal']"))));

        SwipeActions swipeActions = new SwipeActions(driver);
        swipeActions.swipeLeft();
        swipeActions.swipeRight();

        int Swipetry = 0;
        boolean DisplayedElement = true;
        while (DisplayedElement && Swipetry < 5) {
            try {
                boolean ValidateElement = driver.findElement(AppiumBy.xpath("//*[@text='EXTENDABLE']")).isDisplayed();
                if (ValidateElement) {
                    DisplayedElement = false;
                }
            } catch (Exception e) {

            }
            swipeActions.swipeLeft();
            Swipetry++;
        }

        File FormScreenshot = driver.getScreenshotAs(OutputType.FILE);
        String FormScreen = System.getProperty("user.dir") + "\\src\\test\\resources\\Formscreenshot.png";

        try {
            FileUtils.copyFile(FormScreenshot, new File(FormScreen));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}

