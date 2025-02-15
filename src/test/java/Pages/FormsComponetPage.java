package Pages;

import Appiumconfigurations.SwipeActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class FormsComponetPage extends BasePage{

    private By FormsLocator = AppiumBy.accessibilityId("Forms");
    private By InputLocator = AppiumBy.accessibilityId("text-input");
    private By SwtichTextLocator = AppiumBy.accessibilityId("switch-text");
    private By SwitchElementLocator = AppiumBy.accessibilityId("switch");
    private By DropdownLocator = AppiumBy.accessibilityId("Dropdown");
    private By SelectElementLocator = AppiumBy.xpath("//*[@text='webdriver.io is awesome']");
    private By ActiveButtonLocator = AppiumBy.xpath("//*[@text='Active']");
    public FormsComponetPage(AppiumDriver driver) {
        super(driver);
    }

    public void FormActions (String input) {
        click(FormsLocator);
        type(InputLocator, input);
        System.out.println(getElement(SwtichTextLocator).getText());
        click(SwitchElementLocator);
        click(DropdownLocator);
        click(SelectElementLocator);
        SwipeActions SwipeActions = new SwipeActions(driver);
        SwipeActions.swipeBottom();
        click(ActiveButtonLocator);

    }
}
