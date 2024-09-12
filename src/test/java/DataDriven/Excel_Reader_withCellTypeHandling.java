package DataDriven;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Excel_Reader_withCellTypeHandling  
{

    public static void main(String[] args) 
    {
        try 
        {
            FileInputStream file = new FileInputStream(new File("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\FaceifyEdu\\\\Excels\\\\Student_Creation_Page_TestData.xlsx"));
        	
            // Create Workbook instance holding reference to .xlsx file
            Workbook workbook = new XSSFWorkbook(file);

            // Get the first sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0);

            // Iterate through each row one by one
            for (Row row : sheet) 
            {
                // For each row, iterate through all the columns
                for (Cell cell : row) 
                {
                    if (cell != null) 
                    {
                        // Check the cell type and act accordingly
                        switch (cell.getCellType()) 
                        {
                            case STRING:
                                System.out.println("String value: " + cell.getStringCellValue());
                                break;
                            case NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) 
                                {
                                    System.out.println("Date value: " + cell.getDateCellValue());
                                } 
                                else 
                                {
                                    System.out.println("Numeric value: " + cell.getNumericCellValue());
                                }
                                break;
                            case BOOLEAN:
                                System.out.println("Boolean value: " + cell.getBooleanCellValue());
                                break;
                            case FORMULA:
                                System.out.println("Formula: " + cell.getCellFormula());
                                break;
                            case BLANK:
                                System.out.println("Blank cell");
                                break;
                            default:
                                System.out.println("Unknown cell type");
                        }
                    } 
                    else 
                    {
                        System.out.println("Null cell");
                    }
                }
            }

            file.close();
            workbook.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}


