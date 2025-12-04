package datadriven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataTest {

    @DataProvider(name = "excelData")  //It'll provide name for excel sheet and it'll send it to test
    public Object[][] excelDataProvider() {
        return ExcelUtils.getExcelData("C:\\SDET_Training_UJITHA_K\\TestingFrameworks-TestNG&JUnit\\Datadriven\\test_data.xlsx", "Sheet1");
    }

    @Test(dataProvider = "excelData")
    public void excelTest(String username, String password) {
        System.out.println("Excel sheet data Username: " + username + ", Password: " + password);
    }
}
