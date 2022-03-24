package practice;

import org.testng.annotations.Test;

public class IncludeTest {
	 
	@Test(groups="integrationTest")
	public void fruits() {
		System.out.println("mango");
	}

	@Test(groups="systemTest")
	public void bagBrand() {
		System.out.println("Kate Spade");
	}

	@Test(groups="endToEndTest")
	public void bucketList() {
		System.out.println("paris");
	}

	@Test(groups="integrationTest")
	public void company() {
		System.out.println("SAP");
	}

	@Test(groups="systemTest")
	public void favColor() {
		System.out.println("purple");
	}
}
