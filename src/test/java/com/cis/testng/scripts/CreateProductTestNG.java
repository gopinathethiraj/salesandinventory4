package com.cis.testng.scripts;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.sis.ObjRepo.AddCustomerPage;
import com.sis.ObjRepo.AddProductPage;
import com.sis.ObjRepo.AdminHomePage;
import com.sis.ObjRepo.CustomerPage;
import com.sis.ObjRepo.ProductPage;

public class CreateProductTestNG extends BaseClass {

	@Test
	public void createProduct() throws Throwable {
	AdminHomePage hp = new AdminHomePage(driver);
	hp.productModule();
	
	ProductPage cp=new ProductPage(driver);
	cp.addproductbuttonModule();
	
	AddProductPage cus= new AddProductPage(driver);
	String prodcode = eLib.readDataFromExcel("Sheet1",0,1);
	String name = eLib.readDataFromExcel("Sheet1",1,1);
	String description= eLib.readDataFromExcel("Sheet1",2,1);
	String quantity = eLib.readDataFromExcel("Sheet1",3,1);
	String onhand = eLib.readDataFromExcel("Sheet1",4,1);
	String price = eLib.readDataFromExcel("Sheet1",5,1);
	cus.enterProductdetails(prodcode, name, description, quantity, onhand, price, wLib);
	System.out.println("Created product successfully");
	}
	
}
