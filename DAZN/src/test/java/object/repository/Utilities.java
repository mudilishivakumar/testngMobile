package object.repository;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;

import static test.cases.LoginAppValidation.driver;

public class Utilities {

    public void swipeAction(WebElement firstImage, String swipeDirection) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) firstImage).getId(),
                "direction", swipeDirection,
                "percent", 0.75
        ));
    }

    public void scrollEnd(WebElement firstImage, String scrollDirection) {
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) firstImage).getId(),

                    "direction", scrollDirection, "percent", 3
            ));
        } while (canScrollMore);
    }

    public void scrollToElement(String ele) {
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().textContains(\"ele\"))"));
    }



}