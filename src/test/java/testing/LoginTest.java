package testing;

import Appiumconfigurations.AppiumDriverConfig;
import Pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
@Story("Valid Login")
public class LoginTest {
    @Test
    @Description("Verify user can login with valid credentials")
    public void LoginWithCredentials() {
        AndroidDriver driver = AppiumDriverConfig.GetAppiumDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("test@test.com", "test@test.com");
    }
}
