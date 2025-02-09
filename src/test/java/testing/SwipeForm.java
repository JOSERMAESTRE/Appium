package testing;

import Appiumconfigurations.AppiumDriverConfig;
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
import java.util.NoSuchElementException;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;

public class SwipeForm {
    public static void main(String[] args){
        AppiumDriver driver = AppiumDriverConfig.GetAppiumDriver();
        WebElement SwipeLabel = driver.findElement(AppiumBy.accessibilityId("Swipe"));
        SwipeLabel.click();

        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.xpath("//*[@text='Swipe horizontal']"))));

        Dimension size = driver.manage().window().getSize();
        int width = size.width;
        int height = size.height;
        int startX = width * 50 / 100; //centro horizontal
        int endX =  width * 10 / 100; // limite izquierdo horizontal
        int startY = height * 50 / 100;//centro vertical
        int endY = startY;//igual que el anterior ya que, el movimiento solo sera horizontal

        PointerInput finger = new PointerInput(TOUCH, "finger");
        MoveLeft(startX,startY,endX,endX,finger,driver);

      
        Sequence swipeBack = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(ofMillis(0), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerDown(LEFT.asArg()))
                .addAction(finger.createPointerMove(ofMillis(700), PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerUp(LEFT.asArg()));

        driver.perform(List.of(swipeBack));
        int Swipetry = 0;
        boolean DisplayedElement = true;
       while(DisplayedElement && Swipetry < 5){
            try {


                boolean ValidateElement = driver.findElement(AppiumBy.xpath("//*[@text='EXTENDABLE']")).isDisplayed();
                if(ValidateElement) {
                    DisplayedElement = false;
                }
            } catch (Exception e) {

            }
           MoveLeft(startX, startY, endX, endX, finger, driver);
           Swipetry++;
        }

        File FormScreenshot = driver.getScreenshotAs(OutputType.FILE);
        String FormScreen = System.getProperty("user.dir") + "\\src\\test\\resources\\Formscreenshot.png";

        try {
            FileUtils.copyFile(FormScreenshot,new File(FormScreen) );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void MoveLeft(int startX , int startY , int endX , int endY ,PointerInput finger , AppiumDriver driver ){
        Sequence swipeLeft = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(ofMillis(0), PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(LEFT.asArg()))
                .addAction(finger.createPointerMove(ofMillis(700), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(LEFT.asArg()));

        driver.perform(List.of(swipeLeft));
    }
}

