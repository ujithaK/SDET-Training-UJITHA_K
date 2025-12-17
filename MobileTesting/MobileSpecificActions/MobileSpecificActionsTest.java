package com.automation.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MobileSpecificActionsTest {

    AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Android Emulator");
        options.setPlatformName("Android");
        options.setApp("C:\\apps\\com.swaglabsmobileapp--12.apk");
        options.setAutomationName("UiAutomator2");

        options.setAppPackage("com.swaglabsmobileapp");
        options.setAppActivity("com.swaglabsmobileapp.SplashActivity");

        options.setCapability("ignoreHiddenApiPolicyError", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }


    @Test
    public void mobileActionsTest() throws InterruptedException {
        // 1️ Install / Uninstall App

        System.out.println("Installing app...");
        driver.installApp("C:\\apps\\com.swaglabsmobileapp--12.apk");
        System.out.println("Is app installed? " + driver.isAppInstalled("com.swaglabsmobileapp"));

        if (driver.isAppInstalled("com.swaglabsmobileapp")) {
            System.out.println("Uninstalling app...");
            driver.removeApp("com.swaglabsmobileapp");
        }

        // Reinstall app for further tests
        driver.installApp("C:\\apps\\com.swaglabsmobileapp--12.apk");

        // 2️ Background / Foreground Test
        System.out.println("Sending app to background for 5 seconds...");
        driver.runAppInBackground(Duration.ofSeconds(5));
        System.out.println("App back to foreground");

        // 3️ Handle Notifications / Alerts

        try {
            driver.switchTo().alert().accept();
            System.out.println("Alert accepted");
        } catch (Exception e) {
            System.out.println("No alert present");
        }

        // 4️ Rotate Device Orientation
        // Before rotating, checking device orientation
        System.out.println("Current orientation: " + driver.getOrientation());
        System.out.println("Rotating to LANDSCAPE");
        driver.rotate(ScreenOrientation.LANDSCAPE);
        Thread.sleep(2000);

        System.out.println("Rotating back to PORTRAIT");
        driver.rotate(ScreenOrientation.PORTRAIT);
        System.out.println("Current orientation: " + driver.getOrientation());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
