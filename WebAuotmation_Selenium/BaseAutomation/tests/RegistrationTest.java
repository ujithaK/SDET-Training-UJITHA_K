
package tests;

import base.Utilities;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import base.BaseTest;
import java.lang.InterruptedException;

public class RegistrationTest extends BaseTest {

    @Test
    public void userRegistration() {
        driver.get("https://candymapper.com/m/create-account");
        RegistrationPage reg = new RegistrationPage(driver);

       try{
           Thread.sleep(3000);
           reg.registerUser("Ujitha","reddy", "test@example.com", "943834582");
           Utilities.takeScreenshot(driver,"register");
       }catch(Exception e){
           e.getMessage();

       }
    }
}


