package tests;

import base.Utilities;
import org.testng.annotations.Test;
import pages.FormPage;
import base.BaseTest;

public class FormTest extends BaseTest {

    @Test
    public void submitForm() {
        driver.get("https://www.tutorialspoint.com/selenium/practice/register.php");
        FormPage form = new FormPage(driver);

        form.fillForm("uji","ujitha","ujitha_reddy","Ujitha432");
        Utilities.takeScreenshot(driver,"formm");
    }
}
