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

   /* public static String getCellData(int rowNum, int colNum) {
       Cell cell = sheet.getRow(rowNum).getCell(colNum);
        return cell.getStringCellValue();
   }*/
    /*public static String getCellData(int rowNum, int colNum) {
        Cell cell = sheet.getRow(rowNum).getCell(colNum);
        CellType cellType = cell.getCellType();

        switch (cellType) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }*/
    public static String getCellData(int rowNum, int colNum) {
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            return "";  // Return empty string if row is null
        }
        
        Cell cell = row.getCell(colNum);
        if (cell == null) {
            return "";  // Return empty string if cell is null
        }
        
        CellType cellType = cell.getCellType();
        
        switch (cellType) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }

   /* public static int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public static int getColCount() {
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }*/
    public static int getRowCount() {
        int numberOfRows = 0;
        for (Row row : sheet) {
            if (row != null && row.getCell(0) != null && !row.getCell(0).getStringCellValue().trim().isEmpty()) {
                numberOfRows++;
            }
        }
        return numberOfRows;
    }

    public static int getColCount() {
        Row row = sheet.getRow(0);
        if (row != null) {
            return row.getPhysicalNumberOfCells();
        } else {
            return 0;
        }
    }
}
