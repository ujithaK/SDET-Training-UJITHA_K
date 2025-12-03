import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.LocalDate;
public class AdvancedElementHandling {




    public static void main(String[] args) throws Exception {
        // Set path to your chromedriver executable
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);

        try {
            // Open the practice page
            driver.get("https://techbeamers.com/selenium-practice-test-page/");
            driver.manage().window().maximize();
            Thread.sleep(2000);

            // --- 1. Dropdown ---
            WebElement dropdown = driver.findElement(By.id("country")); //it will find the particular select dropdown
            Select select = new Select(dropdown);
            select.selectByVisibleText("Canada");
            Thread.sleep(3000);

//             --- 2. File Upload ---
            WebElement fileInput = driver.findElement(By.id("browse-files"));
            fileInput.sendKeys("C:\\Users\\Ujitha K\\Pictures\\Screenshots\\Screenshot (3).png");

            Thread.sleep(5000);


            // --- 3. Drag & Drop ---
            WebElement source = driver.findElement(By.id("item1")); // Example ID
            WebElement target = driver.findElement(By.id("dropzone")); // Example ID
//            actions.dragAndDrop(source,target).perform();
            actions.clickAndHold(source) //it'll click the box and hold it for 5millisec and it will move towards the target
                    .pause(500)
                    .moveToElement(target)
                    .pause(500)
                    .release()
                    .build()
                    .perform();
            Thread.sleep(4000);


            // --- 4. Hover + Right-Click ---
            WebElement hoverElement = driver.findElement(By.id("progress-decrease")); // Example ID
            actions.moveToElement(hoverElement).perform(); // hover
            Thread.sleep(2000);
            actions.contextClick(hoverElement).perform(); // right-click
            Thread.sleep(2000);


            System.out.println("Test completed successfully!");

        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }

    //5 Calender
    @Test
    public void calendarTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/date-picker");
        driver.findElement(By.id("datePickerMonthYearInput")).click();
        // Pick today + 10 days (change as needed)
        LocalDate target = LocalDate.now().plusDays(10);

        int targetDay = target.getDayOfMonth();
        String str = target.getMonth().name();
        String targetMonth = str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();

        String targetYear = String.valueOf(target.getYear());

        // Select Month
        Select month = new Select(driver.findElement(By.xpath("//*[@id=\"datePickerMonthYear\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select")));
        month.selectByVisibleText(targetMonth);
        // Select Year
        Select year = new Select(driver.findElement(By.xpath("//*[@id=\"datePickerMonthYear\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select")));
        year.selectByVisibleText(targetYear);
        // Select Day
//        driver.findElement(By.xpath("//*[@id=\"datePickerMonthYear\"]/div[2]/div[2]/div/div/div[2]/div[2]")).click();
        Thread.sleep(1500);
    }
}
