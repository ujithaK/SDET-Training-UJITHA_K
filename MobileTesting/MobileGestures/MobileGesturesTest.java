package com.automation.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.*;

import java.net.URL;
import java.time.Duration;
import java.util.List;

public class MobileGesturesTest {

    AndroidDriver driver;
    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

    @BeforeClass
    public void setup() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName("OPPO CPH2223")
                .setAutomationName("UIAutomator2")
                .setAppPackage("io.appium.android.apis")
                .setAppActivity(".ApiDemos");
                options.setCapability("noReset", true);
                options.setCapability("fullReset", false);
                options.setCapability("ignoreHiddenApiPolicyError", true);


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }

    @Test
    public void gesturesDemo() {
        performGesture(driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")),
                driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Lists\"]")));
    }

    // ONE METHOD FOR ALL GESTURES
    void performGesture(WebElement tapEl, WebElement longPressEl) {
        // TAP
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.fromElement(tapEl), 0, 0));
        tap.addAction(finger.createPointerDown(0));
        tap.addAction(finger.createPointerUp(0));

        // LONG PRESS
        Sequence longPress = new Sequence(finger, 1);
        longPress.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.fromElement(longPressEl), 0, 0));
        longPress.addAction(finger.createPointerDown(0));
        longPress.addAction(finger.createPointerMove(Duration.ofMillis(1500), PointerInput.Origin.fromElement(longPressEl), 0, 0));
        longPress.addAction(finger.createPointerUp(0));

        // SWIPE / PULL TO REFRESH (vertical)
        int startY = driver.manage().window().getSize().height / 5;
        int endY = driver.manage().window().getSize().height * 4 / 5;
        int midX = driver.manage().window().getSize().width / 2;
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), midX, startY));
        swipe.addAction(finger.createPointerDown(0));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), midX, endY));
        swipe.addAction(finger.createPointerUp(0));

        driver.perform(List.of(tap, longPress, swipe));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
