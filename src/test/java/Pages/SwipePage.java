package Pages;

import Appiumconfigurations.SwipeActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class SwipePage extends BasePage {
    private final By SwipeLabelLocator = AppiumBy.accessibilityId("Swipe");
    private final By FormTitleLocator = AppiumBy.xpath("//*[@text='Swipe horizontal']");

    public SwipePage(AndroidDriver driver) {
        super(driver);
    }

    public void swipeLeft(String targetLabel) throws InterruptedException {
        click(SwipeLabelLocator);
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(FormTitleLocator)));
        SwipeActions swipeActions = new SwipeActions(driver);
        swipeActions.swipeLeft();
        swipeActions.swipeRight();

        if (targetLabel.equals("EXTENDABLE")){
            int SwipeLimit = 4;
            while(SwipeLimit > 0 ){
                swipeActions.swipeLeft();
                SwipeLimit--;
                Thread.sleep(500);
            }
        }
    }
}
