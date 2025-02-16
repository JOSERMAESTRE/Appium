package testing;

import Appiumconfigurations.AppiumDriverConfig;
import Pages.AndroidSettingsPage;
import Pages.SignUpPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
@Story("Valid Sign Up")
public class SignUpTest {
    @Test
    @Description("Verify user can signup with valid data")
    public void SigningUp() {
        AndroidDriver driver = AppiumDriverConfig.GetAppiumDriver();
        ((CanRecordScreen) driver).startRecordingScreen();
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.SignUp("test@gmail.com", "12345678", "12345678");
        String Video = ((CanRecordScreen) driver).stopRecordingScreen();

        byte[] DecodedVideo = Base64.getDecoder().decode(Video);
        Path VideoDir = Path.of(System.getProperty("user.dir") + "/videos");
        try {
            Files.createDirectories(VideoDir);
            Path Videopath = Path.of(VideoDir.toString(), String.format("%s-%d.%s", "Test", System.currentTimeMillis(), "mp4"));
            Files.write(Videopath, DecodedVideo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        AndroidSettingsPage settingsPage = new AndroidSettingsPage(driver);
        settingsPage.WifiActions();

        driver.activateApp("com.wdiodemoapp");

        driver.findElement(AppiumBy.xpath("//*[@text='OK']")).click();

    }
}
