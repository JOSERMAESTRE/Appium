package Pages;

import Appiumconfigurations.SwipeActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class FormsComponentPage extends BasePage{

    private final By FormsLocator = AppiumBy.accessibilityId("Forms");
    private final By InputLocator = AppiumBy.accessibilityId("text-input");
    private final By SwitchTextLocator = AppiumBy.accessibilityId("switch-text");
    private final By SwitchElementLocator = AppiumBy.accessibilityId("switch");
    private final By DropdownLocator = AppiumBy.accessibilityId("Dropdown");
    private final By SelectElementLocator = AppiumBy.xpath("//*[@text='webdriver.io is awesome']");
    private final By ActiveButtonLocator = AppiumBy.xpath("//*[@text='Active']");
    public FormsComponentPage(AndroidDriver driver) {
        super(driver);
    }

    public void FormActions (String input) {
        click(FormsLocator);
        type(InputLocator, input);
        System.out.println(getElement(SwitchTextLocator).getText());
        click(SwitchElementLocator);
        click(DropdownLocator);
        click(SelectElementLocator);
        SwipeActions SwipeActions = new SwipeActions(driver);
        SwipeActions.swipeBottom();
        click(ActiveButtonLocator);

    }
}
