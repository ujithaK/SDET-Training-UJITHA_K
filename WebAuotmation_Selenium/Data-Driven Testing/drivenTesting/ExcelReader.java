//package drivenTesting;
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileInputStream;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//public class ExcelReader {
//
//    public static List<String[]> readExcel(String filePath, String sheetName) {
//        List<String[]> data = new ArrayList<>();
//
//        try {
//            FileInputStream fis = new FileInputStream(filePath);
//            Workbook workbook = new XSSFWorkbook(fis);
//            Sheet sheet = workbook.getSheet(sheetName);
//            Iterator<Row> rows = sheet.iterator();
//            rows.next(); // Skip header
//
//            while (rows.hasNext()) {
//                Row row = rows.next();
//                String username = row.getCell(0).getStringCellValue();
//                String password = row.getCell(1).getStringCellValue();
//                data.add(new String[]{username, password});
//            }
//            workbook.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return data;
//    }
//}


package drivenTesting;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {

    public static List<String[]> readExcel(String filePath, String sheetName) {
        List<String[]> dataList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                System.out.println(" ERROR: Sheet not found → " + sheetName);
                System.out.println(" Available Sheets:");
                for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                    System.out.println(" - " + workbook.getSheetName(i));
                }
                return dataList; // return empty to avoid NPE
            }

            Iterator<Row> rowIterator = sheet.iterator();

            // Skip header
            if (rowIterator.hasNext()) rowIterator.next();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                String username = row.getCell(0).getStringCellValue();
                String password = row.getCell(1).getStringCellValue();

                dataList.add(new String[]{username, password});
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }
}

