package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SignUpPage extends BasePage {
    private final By LoginLabelLocator = AppiumBy.accessibilityId("Login");
    private final By SignupTabLocator = AppiumBy.xpath("//*[@text='Sign up']");
    private final By EmailLocator = AppiumBy.accessibilityId("input-email");
    private final By PasswordLocator = AppiumBy.accessibilityId("input-password");
    private final By ConfirmPasswordLocator = AppiumBy.accessibilityId("input-repeat-password");
    private final By SignUpButtonLocator = AppiumBy.accessibilityId("button-SIGN UP");

    public SignUpPage(AndroidDriver driver) {
        super(driver);
    }

    public void SignUp(String email, String password, String repeatPassword) {
        click(LoginLabelLocator);
        click(SignupTabLocator);
        type(EmailLocator, email);
        type(PasswordLocator, password);
        type(ConfirmPasswordLocator, repeatPassword);
        click(SignUpButtonLocator);
    }
}
