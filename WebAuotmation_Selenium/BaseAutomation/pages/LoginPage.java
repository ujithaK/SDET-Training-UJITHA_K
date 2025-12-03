package pages;
import org.openqa.selenium.*;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By email = By.name("email");
    By password = By.name("password");
    By loginBtn = By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[3]/button");

    public void login(String e, String p) {
       try{
           driver.findElement(email).sendKeys(e);
           driver.findElement(password).sendKeys(p);
           driver.findElement(loginBtn).click();
           Thread.sleep(5000);

       }catch (Exception ex){
           ex.printStackTrace();
       }
    }
}

