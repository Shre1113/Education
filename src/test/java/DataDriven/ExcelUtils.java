package DataDriven;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    private static Workbook workbook;
    private static Sheet sheet;

    public static void setExcelFile(String excelFilePath, String sheetName) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(excelFilePath)) {
            workbook = new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheet(sheetName);

            if (sheet == null) 
            {
                throw new IllegalArgumentException("Sheet with name '" + sheetName + "' does not exist in the file: " + excelFilePath);
            }

            System.out.println("Excel file and sheet set successfully.");
        } catch (IOException e) 
        {
            System.err.println("Error reading the Excel file: " + e.getMessage());
            throw e;
        }
    }

    public static String getCellData(int rowNum, int colNum) {
        Cell cell = sheet.getRow(rowNum).getCell(colNum);
        return cell.getStringCellValue();
    }

    public static int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public static int getColCount() {
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }
}
