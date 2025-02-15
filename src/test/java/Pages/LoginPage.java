package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    private final By LoginLabel = AppiumBy.accessibilityId("Login");
    private final By UsernameLocator = AppiumBy.accessibilityId("input-email");
    private final By PasswordLocator = AppiumBy.accessibilityId("input-password");
    private final By LoginButton = AppiumBy.accessibilityId("button-LOGIN");
    private final By AlertMessage = AppiumBy.id("android:id/alertTitle");
    private final By OKButton = AppiumBy.xpath("//*[@text='OK']");

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        click(LoginLabel);
        type(UsernameLocator, email);
        type(PasswordLocator, password);
        click(LoginButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successfulMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(AlertMessage));
        System.out.println("Log-in is: "+ successfulMessage.getText());
        click(OKButton);

    }

}
