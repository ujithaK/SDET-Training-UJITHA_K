package com.automation.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.net.URL;


public class MobileWebTest {
    public static void main(String[] args) throws MalformedURLException {
        // 1️ Setting capabilities for the Android emulator
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("OPPO CPH2223")
                .setPlatformName("Android")
                .setPlatformVersion("13.0")
                .setAutomationName("UIAutomator2")
                .setChromedriverExecutable("C:\\drivers\\chromedriver.exe") // path to chromedriver


        // 2️ Initialize AndroidDriver
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);

        try {
            // 3️ Navigating to a google website
            driver.get("https://www.google.com");

            // 4️ Interacting  with elements
            driver.findElement(By.id("com.google.android.googlequicksearchbox:id/googleapp_search_box")).sendKeys("Chocolates");

            Thread.sleep(5000); // wait to see results
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5️ Close the session
            driver.quit();
        }
    }
}
