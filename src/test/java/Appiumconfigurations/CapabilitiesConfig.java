package Appiumconfigurations;

import org.openqa.selenium.Capabilities;

public interface CapabilitiesConfig extends Capabilities {
    String APP_PACKAGE = "appium:appPackage";
    String APP_ACTIVITY = "appium:appActivity";
    String DEVICE_ID = "appium:udid";
    String PLATFORM_NAME = "appium:platformName";
    String AUTOMATION_NAME = "appium:automationName";
}
