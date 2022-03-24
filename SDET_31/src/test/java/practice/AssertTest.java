package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertTest {
	@Test
	public void assertTest() {
		String actualName = "Ramya";
		String expectedname = "Samya";
		Assert.assertEquals(actualName, expectedname);//for string comparison
		
		int x=10;
		int y=10+0;
		Assert.assertEquals(y, x);// for integer comparison
		
		
	}
}
