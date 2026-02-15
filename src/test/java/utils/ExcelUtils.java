package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

	public static Object[][] getExcelData(String filePath, String sheetName)
	{

		// return type as two dimensional array
		Object[][] data = null;

		// Reading the file from the fileInput stream
		try (FileInputStream fis = new FileInputStream(filePath); 
				Workbook workbook = new XSSFWorkbook(fis))
		{
            //Reading the sheet which we have saved in the test-data folder which Name and Sheet should be the same
			Sheet sheet = workbook.getSheet(sheetName);
            
			//reading the number of rows count by finding the first row last cell number
			int rowCount = sheet.getLastRowNum();
			
			//Reading the number of columns by finding the first column last cell
			int colCount = sheet.getRow(1).getPhysicalNumberOfCells();
			
            //This fallows the regular apache POI code
			data = new Object[rowCount - 1][colCount];

			for (int i = 1; i < rowCount; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < colCount; j++) {
					Cell cell = row.getCell(j);
					data[i - 1][j] = cell.toString();
				}
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return data;
	}
}


/*This class is called a Data Provider class in TestNG.
It is used to implement Data Driven Testing.
The @DataProvider annotation supplies multiple sets of data to a test method, so that the same test can be executed multiple times with different inputs.
In this example, the method getLoginData() returns a two-dimensional Object array, where each row represents one set of username and password.
This helps in keeping test data separate from test logic and improves reusability and maintainability.
*/

















