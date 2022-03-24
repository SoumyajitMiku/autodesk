package practice;

import org.testng.annotations.Test;

public class ExcludeTestNG {
	
	@Test(groups={"integrationTest","systemTest"})
	public void fruits() {
		System.out.println("Watermelon");
	}

	@Test(groups="systemTest")
	public void bagBrand() {
		System.out.println("Caprese");
	}

	@Test(groups={"endToEndTest","integrationTest"})
	public void bucketList() {
		System.out.println("San Francisco");
	}

	@Test(groups="integrationTest")
	public void company() {
		System.out.println("SAP");
	}

	@Test(groups="integrationTest")
	public void favColor() {
		System.out.println("purple");
	}
}
