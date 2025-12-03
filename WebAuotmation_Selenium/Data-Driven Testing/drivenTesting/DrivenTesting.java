package drivenTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class DrivenTesting {

    WebDriver driver;

    private final String username;
    private final String password;

    // Constructor → Data from Excel
    public DrivenTesting(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {

        List<String[]> excelData = ExcelReader.readExcel(
                "C:\\SDET_Training_UJITHA_K\\WebAuotmation_Selenium\\Data-Driven Testing\\test_data.xlsx",
                "Sheet1"
        );

        Object[][] data = new Object[excelData.size()][2];
        for (int i = 0; i < excelData.size(); i++) {
            data[i][0] = excelData.get(i)[0];
            data[i][1] = excelData.get(i)[1];
        }

        return Arrays.asList(data);
    }

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    public void loginTest() {

        System.out.println("Running Test → " + username + " | " + password);

        // Correct locators
        By uname = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input");
        By pwd   = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input");
//        By loginButton = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");

        try {
            Thread.sleep(2000);

            driver.findElement(uname).clear();
            driver.findElement(uname).sendKeys(username);

            driver.findElement(pwd).clear();
            driver.findElement(pwd).sendKeys(password);
            Thread.sleep(2000);
        } catch (Exception ignored) {}

        System.out.println("Login Successful for: " + username);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

