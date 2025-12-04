package datadriven;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtils {


    //this entire method is responsibile for reading the excel sheet
    public static Object[][] getExcelData(String filePath, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(filePath);  //read the raw file bytes
            Workbook wb = new XSSFWorkbook(fis); //used for .xlsx files
            Sheet sheet = wb.getSheet(sheetName);

            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getLastCellNum();

            Object[][] data = new Object[rows - 1][cols]; //row-1 because 0th row will be heading row

            for (int i = 1; i < rows; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < cols; j++) {
                    data[i - 1][j] = row.getCell(j).toString();
                }
            }
            return data;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
