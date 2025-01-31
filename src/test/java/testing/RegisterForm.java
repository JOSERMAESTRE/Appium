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
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static java.time.Duration.ofMillis;
import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class RegisterForm {
    public static void main(String[] args){
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

        Dimension size = driver.manage().window().getSize();
        int width = size.width;
        int height = size.height;
        int startX = width * 50 / 100;  // Centro horizontal
        int endX = startX;              // Mismo X para swipe vertical
        int startY = height * 90 / 100; // 90% abajo
        int endY = height * 10 / 100;   // 10% arriba


        PointerInput finger = new PointerInput(TOUCH, "finger");
        Sequence swipeDown = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(ofMillis(0), PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(LEFT.asArg()))
                .addAction(finger.createPointerMove(ofMillis(700), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(LEFT.asArg()));

        driver.perform(List.of(swipeDown));

        WebElement Dropdown = driver.findElement(AppiumBy.accessibilityId("Dropdown"));
        Dropdown.click();

        WebElement FirstOne = driver.findElement(AppiumBy.xpath("//*[@text='webdriver.io is awesome']"));
        FirstOne.click();

        Sequence swipeUP = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(ofMillis(0), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerDown(LEFT.asArg()))
                .addAction(finger.createPointerMove(ofMillis(700), PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerUp(LEFT.asArg()));

        driver.perform(List.of(swipeUP));
        File FormScreenshot = driver.getScreenshotAs(OutputType.FILE);
        String FormScreen = System.getProperty("user.dir") + "\\src\\test\\resources\\Formscreenshot.png";

        try {
            FileUtils.copyFile(FormScreenshot,new File(FormScreen) );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

