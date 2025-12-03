package pages;

import org.openqa.selenium.*;

public class FormPage {

    WebDriver driver;

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    By fname = By.id("firstname");
    By lname=By.id("lastname");
    By usrname=By.id("username");
    By pswd=By.id("password");
    By submitBtn = By.xpath("//*[@id=\"signupForm\"]/div[5]/input");

    public void fillForm(String fn,String ln,String un,String ps) {
       try{
           driver.findElement(fname).sendKeys(fn);
           driver.findElement(lname).sendKeys(ln);
           driver.findElement(usrname).sendKeys(un);
           driver.findElement(pswd).sendKeys(ps);
           driver.findElement(submitBtn).click();
           Thread.sleep(6000);

       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }
}
