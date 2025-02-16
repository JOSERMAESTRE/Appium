package Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected AndroidDriver driver;

    BasePage(AndroidDriver driver) {
        this.driver = driver;
    }


    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public void click(By locator) {
        getElement(locator).click();
    }

    public void type(By locator, String text) {
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }
}
