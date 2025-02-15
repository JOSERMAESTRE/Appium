package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    private By LoginLabel = AppiumBy.accessibilityId("Login");
    private By UsernameLocator = AppiumBy.accessibilityId("input-email");
    private By PasswordLocator = AppiumBy.accessibilityId("input-password");
    private By LoginButton = AppiumBy.accessibilityId("button-LOGIN");
    private By AlertMessage = AppiumBy.id("android:id/alertTitle");
    private By OKButton = AppiumBy.xpath("//*[@text='OK']");

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        click(LoginLabel);
        type(UsernameLocator, email);
        type(PasswordLocator, password);
        click(LoginButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successfullMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(AlertMessage));
        System.out.println("Log-in is: "+ successfullMessage.getText());
        click(OKButton);

    }

}
