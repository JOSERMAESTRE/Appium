package testing;

import Appiumconfigurations.AppiumDriverConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.screenrecording.CanRecordScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Base64;

public class RecordVideo {

    public static void main(String[] args) {
        AndroidDriver driver = AppiumDriverConfig.GetAppiumDriver();
        ((CanRecordScreen) driver).startRecordingScreen();

        WebElement LoginLabel = driver.findElement(AppiumBy.accessibilityId("Login"));
        LoginLabel.click();

        WebElement SignUpLabel = driver.findElement(AppiumBy.xpath("//*[@text='Sign up']"));
        SignUpLabel.click();

        WebElement UserNameLabel = driver.findElement(AppiumBy.accessibilityId("input-email"));
        UserNameLabel.sendKeys("test@test.com");
        WebElement PasswordLabel = driver.findElement(AppiumBy.accessibilityId("input-password"));
        PasswordLabel.sendKeys("12345678");
        WebElement ComfirmPasswordLabel = driver.findElement(AppiumBy.accessibilityId("input-repeat-password"));
        ComfirmPasswordLabel.sendKeys("12345678");
        WebElement LoginButton = driver.findElement(AppiumBy.accessibilityId("button-SIGN UP"));
        LoginButton.click();

        String Video = ((CanRecordScreen) driver).stopRecordingScreen();

        byte[] DecodedVideo = Base64.getDecoder().decode(Video);
        Path VideoDir = Path.of(System.getProperty("user.dir") + "/videos");
        try {
            Files.createDirectories(VideoDir);
            Path Videopath = Path.of(VideoDir.toString(), String.format("%s-%d.%s", "Test", System.currentTimeMillis(), "mp4"));
            Files.write(Videopath, DecodedVideo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.runAppInBackground(Duration.ofSeconds(-1));
        driver.activateApp("com.android.settings");
        driver.findElement(AppiumBy.xpath("//*[@text='Network & internet']")).click();

        try {
            driver.findElement(AppiumBy.xpath("//*[@resource-id='android:id/title' and contains(@text, 'Wi')]")).click();
            WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement OFF = Wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//*[@resource-id='android:id/title' and contains(@text, 'AndroidWifi')]")));

            if (OFF.isDisplayed()) {
                driver.findElement(AppiumBy.id("com.android.settings:id/switch_widget")).click();
                driver.findElement(AppiumBy.id("com.android.settings:id/switch_widget")).click();
            } else {
                driver.findElement(AppiumBy.id("com.android.settings:id/switch_widget")).click();
                driver.findElement(AppiumBy.id("com.android.settings:id/switch_widget")).click();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        driver.activateApp("com.wdiodemoapp");

        driver.findElement(AppiumBy.xpath("//*[@text='OK']")).click();

    }
}
