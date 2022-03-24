package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@Test(dataProvider = "getData")

	public void MultipleDataPrint(String name, String company, String email, int empID) {
		System.out.println("name" + name);
		System.out.println("company" + company);
		System.out.println("email" + email);
		System.out.println("empID" + empID);

		System.out.println("==============================");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] objArray = new Object[2][4];

		objArray[0][0] = "Shailaja";
		objArray[0][1] = "Accenture";
		objArray[0][2] = "shailaja@accenture.com";
		objArray[0][3] = 01;

		objArray[1][0] = "Renuka";
		objArray[1][1] = "TCS";
		objArray[1][2] = "renuka@tcs.com";
		objArray[1][3] = 05;

		return objArray;

	}

}
