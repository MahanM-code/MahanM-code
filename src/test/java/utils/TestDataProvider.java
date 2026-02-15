package utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider
{
	@DataProvider(name="loginData")
	public Object[][] getLoginData()
	{
		return new Object[][]
				{
			{"MahanM","Mahan@143"},
			{"MahanM","Mahan@143"}
				};
	}

}

/*It provides test data to TestNG test methods

It supplies multiple sets of input values

It helps in executing the same test with different data*/