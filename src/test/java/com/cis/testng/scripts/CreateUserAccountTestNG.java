package com.cis.testng.scripts;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.sis.ObjRepo.AccountsPage;
import com.sis.ObjRepo.AddSupplierPage;
import com.sis.ObjRepo.AddUserAccountPage;
import com.sis.ObjRepo.AdminHomePage;
import com.sis.ObjRepo.SupplierPage;

public class CreateUserAccountTestNG extends BaseClass {

	@Test(groups= {"smoke","regression"})
	public void userAccount() throws Throwable {
		AdminHomePage hp = new AdminHomePage(driver);
		hp.accountsModule();
		
		AccountsPage sp=new AccountsPage(driver);
		sp.accountsModule();
		
		AddUserAccountPage cus = new AddUserAccountPage(driver);
		String usernameTF= eLib.readDataFromExcel("Sheet2", 0, 1);
		String passwordTF = eLib.readDataFromExcel("Sheet2", 1, 1);
		cus.enteruseraccountdetails(usernameTF, passwordTF, wLib);
		System.out.println("Created user successflly");
		
		
		
	}

}
