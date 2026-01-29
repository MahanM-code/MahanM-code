package utils;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider
{
	@DataProvider(name="excelLoginData")
	public Object[][] loginData()
	{
		    String filePath = "test-data/TestData.xlsx";
	        return ExcelUtils.getExcelData(filePath, "LoginData");
	    }
			}


