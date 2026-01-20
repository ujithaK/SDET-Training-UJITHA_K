package datadriven.xml;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BrowserTest {

    @Test
    @Parameters("browser")
    public void useParameters(@Optional("chrome") String browser) {
        System.out.println("Browser: " + browser);
    }
}
