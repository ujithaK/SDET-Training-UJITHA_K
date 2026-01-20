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

        // Optional: WebDriverManager (Recommended)
        // WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);

        try {
            driver.get("https://techbeamers.com/selenium-practice-test-page/");
            driver.manage().window().maximize();
            Thread.sleep(2000);

            // ===== 1. Dropdown =====
            WebElement dropdown = driver.findElement(By.id("country"));
            Select select = new Select(dropdown);
            select.selectByVisibleText("Canada");
            Thread.sleep(2000);

            // ===== 2. File Upload =====
            WebElement fileInput = driver.findElement(By.id("browse-files"));
            fileInput.sendKeys("C:\\Users\\Ujitha K\\Pictures\\Screenshots\\Screenshot (3).png");
            Thread.sleep(2000);

            // ===== 3. Drag & Drop =====
            WebElement source = driver.findElement(By.id("item1"));
            WebElement target = driver.findElement(By.id("dropzone"));

            actions.clickAndHold(source)
                    .pause(500)
                    .moveToElement(target)
                    .pause(500)
                    .release()
                    .build()
                    .perform();
            Thread.sleep(2000);

            // ===== 4. Hover + Right Click =====
            WebElement hoverElement = driver.findElement(By.id("progress-decrease"));
            actions.moveToElement(hoverElement).perform(); // Hover
            Thread.sleep(1000);
            actions.contextClick(hoverElement).perform(); // Right-click
            Thread.sleep(2000);

            System.out.println("Advanced element handling completed!");
        }
        finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }

    // ===== 5. Calendar Handling =====
    @Test
    public void calendarTest() throws Exception {

        // Optional: WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/date-picker");
        Thread.sleep(1000);

        // Open calendar
        driver.findElement(By.id("datePickerMonthYearInput")).click();
        Thread.sleep(1000);

        // Set Today + 10 days
        LocalDate target = LocalDate.now().plusDays(10);

        int targetDay = target.getDayOfMonth();
        String monthName = target.getMonth().name(); // e.g. MAY
        String targetMonth = monthName.substring(0,1) + monthName.substring(1).toLowerCase(); // May
        String targetYear = String.valueOf(target.getYear());

        // Select month
        Select monthDropdown = new Select(
                driver.findElement(By.className("react-datepicker__month-select")));
        monthDropdown.selectByVisibleText(targetMonth);

        // Select year
        Select yearDropdown = new Select(
                driver.findElement(By.className("react-datepicker__year-select")));
        yearDropdown.selectByVisibleText(targetYear);

        // Select day
        driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day') and not(contains(@class,'outside-month')) and text()='"+targetDay+"']")).click();

        System.out.println("Calendar handling completed! Selected date: " + target);
        Thread.sleep(2000);
        driver.quit();
    }
}
