package pages;

//import org.openqa.selenium.*;
//import org.openqa.selenium.support.*;
//
//public class RegistrationPage {
//
//    WebDriver driver;
//
//    @FindBy(name = "nameFirst")
//    WebElement fname;
//
//    @FindBy(name = "nameLast")
//    WebElement lname;
//
//    @FindBy(name = "email")
//    WebElement email;
//
//    @FindBy(name= "phone")
//    WebElement phone;
//
//    @FindBy(xpath = "//*[@id=\"bs-6\"]/span/div/div/div/form/div[6]/button")
//    WebElement registerBtn;
//
//    public RegistrationPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);  //it is used to init/invoke the @findBy annotation
//    }
//
//    public void register(String firstName,String lastName, String userEmail, long userPhone) {
//        fname.sendKeys(firstName);
//        lname.sendKeys(lastName);
//        email.sendKeys(userEmail);
////        phone.sendKeys(userPhone);
//        registerBtn.click();
//    }
//}


import org.openqa.selenium.*;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    By fname=By.name("nameFirst");
    By lname = By.name("nameLast");
    By email = By.name("email");
    By phone = By.name("phone");
    By registerBtn = By.xpath("//*[@id=\"bs-6\"]/span/div/div/div/form/div[6]/button");

    public void registerUser(String fn,String ln, String e, String p) {

        try{
            driver.findElement(fname).sendKeys(fn);
            driver.findElement(lname).sendKeys(ln);
            driver.findElement(email).sendKeys(e);
            driver.findElement(registerBtn).click();
            Thread.sleep(6000);

        }catch(Exception ex){

        }

    }
}


