package com.automation.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.URL;
import java.time.Duration;

public class CalculatorOpen {

    protected AndroidDriver dr;

    @BeforeClass
    public void setup() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setDeviceName("AndroidDevice");
        options.setAutomationName("UiAutomator2");

        options.setAppPackage("com.coloros.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");

        options.setNoReset(true);
        options.setIgnoreHiddenApiPolicyError(true);

        options.setCapability("uiautomator2ServerInstallTimeout", 60000);
        options.setCapability("uiautomator2ServerLaunchTimeout", 60000);
        options.setCapability("adbExecTimeout", 60000);
        options.setCapability("newCommandTimeout", 300);
        options.setCapability("disableWindowAnimation", true);

        // ---------- OPTIONAL BUT RECOMMENDED ----------
        options.setAutoGrantPermissions(true);

        dr = new AndroidDriver(
                new URL("http://127.0.0.1:4723/"),
                options
        );

        // Global implicit wait (small)
        dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void takeScreenshot(String testName) {
        try {
            File src = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
            File dest = new File("screenshots/" + testName + ".png");
            FileHandler.copy(src, dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (dr != null) {
            dr.quit();
        }
    }
}