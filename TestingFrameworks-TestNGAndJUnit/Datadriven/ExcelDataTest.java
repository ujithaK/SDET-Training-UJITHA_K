package datadriven;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataTest {
    @DataProvider(name = "excelData")
    public Object[][] excelDataProvider() {
        String filePath = "src/test/java/datadriven/test_data.xlsx"; // relative path
        String sheetName = "Sheet1";

        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("Excel file not found at: " + file.getAbsolutePath());
        }

        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }

            int rowCount = sheet.getPhysicalNumberOfRows();
            if (rowCount <= 1) {
                throw new RuntimeException("No data found in sheet: " + sheetName);
            }

            int colCount = sheet.getRow(0).getLastCellNum();
            Object[][] data = new Object[rowCount - 1][colCount]; // exclude header row

            for (int i = 1; i < rowCount; i++) { // start from 1 to skip header
                Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    data[i - 1][j] = getCellValueAsString(cell);
                }
            }

            return data;

        } catch (IOException e) {
            throw new RuntimeException("Failed to read Excel file: " + e.getMessage(), e);
        }
    }

    // Helper to convert different cell types to String
    private String getCellValueAsString(Cell cell) {
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> {
                if (DateUtil.isCellDateFormatted(cell)) {
                    yield cell.getDateCellValue().toString();
                } else {
                    yield String.valueOf(cell.getNumericCellValue());
                }
            }
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            case FORMULA -> cell.getCellFormula();
            case BLANK -> "";
            default -> "";
        };
    }

    // -----------------------
    // Test method using DataProvider
    // -----------------------
    @Test(dataProvider = "excelData")
    public void testWithExcelData(String username, String password) {
        System.out.println("Username: " + username + ", Password: " + password);
    }
}
