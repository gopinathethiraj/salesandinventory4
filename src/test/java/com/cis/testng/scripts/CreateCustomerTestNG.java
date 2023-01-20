  package com.cis.testng.scripts;

import static org.testng.Assert.fail;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.sis.ObjRepo.AddCustomerPage;
import com.sis.ObjRepo.AdminHomePage;
import com.sis.ObjRepo.CustomerPage;
@Listeners(ListenerImplimentationClass.class)
public class CreateCustomerTestNG extends BaseClass 
{
	@Test(retryAnalyzer = com.GenericUtilities.RetryImplimentationClass.class)
	public void createCustomer() throws Throwable {
		
	AdminHomePage hp = new AdminHomePage(driver);
	hp.customerModule();
	
	fail();
	CustomerPage cp=new CustomerPage(driver);
	cp.addcustomerbuttonModule();
	
	AddCustomerPage cus= new AddCustomerPage(driver);
	
	String firstname = eLib.readDataFromExcel("Sheet3",0,1);
	String lastname = eLib.readDataFromExcel("Sheet3",1,1);
	String phonenumber = eLib.readDataFromExcel("Sheet3",2,1);
	cus.firstnametextfield(firstname, lastname, phonenumber);
	cus.savebutton();
	System.out.println("Created customer successfully");
}
}
	
