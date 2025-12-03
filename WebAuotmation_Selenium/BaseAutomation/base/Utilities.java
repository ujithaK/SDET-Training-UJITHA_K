package base;

import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class Utilities {

    public static void takeScreenshot(WebDriver driver, String name) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);  //converting  chromedriver type to Takescreenshot interface type
            File dest = new File("C:\\SDET_Training_UJITHA_K\\WebAuotmation_Selenium\\ScreenshotsFolder\\" +name + ".png");
            FileUtils.copyFile(src, dest);       //it is used to save screenshot from selenium to local file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

