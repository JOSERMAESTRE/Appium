package testing;

import Appiumconfigurations.AppiumDriverConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.screenrecording.CanRecordScreen;
import org.openqa.selenium.WebElement;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class RecordVideo {

    public static void main(String[] args) {
        AppiumDriver driver = AppiumDriverConfig.GetAppiumDriver();
        ((CanRecordScreen) driver).startRecordingScreen();

        WebElement LoginLabel = driver.findElement(AppiumBy.accessibilityId("Login"));
        LoginLabel.click();

        WebElement SignUpLabel = driver.findElement(AppiumBy.xpath("//*[@text='Sign up']"));
        SignUpLabel.click();

        WebElement UserNameLabel = driver.findElement(AppiumBy.accessibilityId("input-email"));
        UserNameLabel.sendKeys("test@test.com");
        WebElement PasswordLabel = driver.findElement(AppiumBy.accessibilityId("input-password"));
        PasswordLabel.sendKeys("123456");
        WebElement ComfirmPasswordLabel = driver.findElement(AppiumBy.accessibilityId("input-repeat-password"));
        ComfirmPasswordLabel.sendKeys("12234");
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

    }
}
