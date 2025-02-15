package testing;

import Appiumconfigurations.AppiumDriverConfig;
import Pages.LoginPage;
import io.appium.java_client.AppiumDriver;


import java.time.Duration;

public class Loggin {
    public static void main(String[] args){
        AppiumDriver driver = AppiumDriverConfig.GetAppiumDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("test@test.com", "test@test.com");
      }
}
