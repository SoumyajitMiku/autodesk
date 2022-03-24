package practice;

import org.testng.annotations.Test;

public class DependsOnMethodSampleTest {
@Test
	public void createAccount() {
		System.out.println("login");
		System.out.println("create account");
		System.out.println("logout");
		
	}
@Test(dependsOnMethods = "createAccount" )
public void modifyAccount() throws Exception {
	System.out.println("login");
	System.out.println("modify account");
	System.out.println("logout");
	throw new Exception();
}
@Test(dependsOnMethods = "modifyAccount")
public void deleteAccount() {
	System.out.println("login");
	System.out.println("delete account");
	System.out.println("logout");
}

}
