package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AndroidSettingsPage extends BasePage {
    String Bundled = "com.android.settings";
    private final By SettingLocator = AppiumBy.xpath("//*[@text='Network & internet']");
    private final By WifiLocator = AppiumBy.xpath("//*[@resource-id='android:id/title' and contains(@text, 'Wi')]");
    private final By ConnectedWifiLocator = AppiumBy.xpath("//*[@resource-id='android:id/title' and contains(@text, 'AndroidWifi')]");
    private final By SwitchLocator = AppiumBy.id("com.android.settings:id/switch_widget");
    public AndroidSettingsPage(AndroidDriver driver) {
        super(driver);
    }

    public void WifiActions(){
        driver.runAppInBackground(Duration.ofSeconds(-1));
        driver.activateApp(Bundled);
        click(SettingLocator);

        try {
            click(WifiLocator);
            WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement OFF = Wait.until(ExpectedConditions.visibilityOfElementLocated(ConnectedWifiLocator));

            if (OFF.isDisplayed()) {
                click(SwitchLocator);
                click(SwitchLocator);
            } else {
                click(SwitchLocator);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
