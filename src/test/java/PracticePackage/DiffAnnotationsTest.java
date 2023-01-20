package PracticePackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DiffAnnotationsTest {
	
	@BeforeMethod
	public void configBM()
	{
		System.out.println("--- Login To App");
	}
	
	@Test
	public void CreateOrg()
	{
		System.out.println("---Navigate to App---");
		System.out.println("---Create Org");
	}
	@AfterMethod
	public void configAM()
	{
		System.out.println("---Logout To App");
	}
	@BeforeClass
	public void configBC()
	{
		System.out.println("---To Launch browser");
	} 
	@Test
	public void CreateContacts()
	{
		System.out.println("---Navigate to App--");
		System.out.println("---CreateContacts");
	}
	@AfterClass
	public void configAC()
	{
		System.out.println("--- To close browser");
	}

}
