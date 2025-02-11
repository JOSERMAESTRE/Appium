package Appiumconfigurations;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.util.List;

import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;

public class SwipeActions {

    private AppiumDriver appiumDriver = null;
    private int startXVertical, startYVertical, endXVertical, endYVertical;
    private int startXHorizontal, startYHorizontal, endXHorizontal, endYHorizontal;

    public SwipeActions(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        initializeSwipeDataVertical();
        initializeSwipeDataHorizontal();
    }

    private void initializeSwipeDataVertical() {
        Dimension size = this.appiumDriver.manage().window().getSize();
        int width = size.width;
        int height = size.height;

        this.startXVertical = width * 50 / 100;  // Centro horizontal
        this.endXVertical = startXVertical;              // Mismo X para swipe vertical
        this.startYVertical = height * 90 / 100; // 90% abajo
        this.endYVertical = height * 10 / 100;   // 10% arriba
    }

    private void initializeSwipeDataHorizontal() {
        Dimension size = this.appiumDriver.manage().window().getSize();
        int width = size.width;
        int height = size.height;

        this.startXHorizontal = width * 50 / 100; //centro horizontal
        this.endXHorizontal = width * 10 / 100; // limite izquierdo horizontal
        this.startYHorizontal = height * 50 / 100;//centro vertical
        this.endYHorizontal = startYHorizontal;//igual que el anterior ya que, el movimiento solo sera horizontal
    }


    public void swipe(int startX, int startY, int endX, int endY) {
        PointerInput finger = new PointerInput(TOUCH, "finger");
        Sequence swipeDown = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(ofMillis(0), PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(LEFT.asArg()))
                .addAction(finger.createPointerMove(ofMillis(700), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(LEFT.asArg()));

        this.appiumDriver.perform(List.of(swipeDown));
    }

    public void swipeBottom() {
        swipe(startXVertical, startYVertical, endXVertical, endYVertical);
    }


    public void swipeUp() {
        swipe(endXVertical, endYVertical, startXVertical, startYVertical);
    }

    public void swipeLeft() {
        swipe(startXHorizontal, startYHorizontal, endXHorizontal, endYHorizontal);
    }

    public void swipeRight() {
        swipe(endXHorizontal, endYHorizontal, startXHorizontal, startYHorizontal);
    }


}
