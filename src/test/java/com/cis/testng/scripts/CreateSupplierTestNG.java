package com.cis.testng.scripts;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.sis.ObjRepo.AddProductPage;
import com.sis.ObjRepo.AddSupplierPage;
import com.sis.ObjRepo.AdminHomePage;
import com.sis.ObjRepo.ProductPage;
import com.sis.ObjRepo.SupplierPage;

public class CreateSupplierTestNG extends BaseClass {
	@Test
	public void CreateSupplier() throws Throwable {
		
		AdminHomePage hp = new AdminHomePage(driver);
		hp.supplierModule();
		
		SupplierPage sp=new SupplierPage(driver);
		sp.addsupplierbuttonModule();
		
		AddSupplierPage cus= new AddSupplierPage(driver);
		String Companyname = eLib.readDataFromExcel("Sheet4",0,1);
		String Phonenumber = eLib.readDataFromExcel("Sheet4",1,1);
		
		String albay = "Abra";
		String city ="Bangued"
				;
		System.out.println(Companyname+"  "+albay+"  "+city+"  "+Phonenumber);
		cus.companynametextfield(Companyname, albay, city, Phonenumber, wLib);
		cus.savebutton();
		System.out.println("Created supplier successfully");
	}
	@Test
	public void simple4() {
		System.out.println("supplier2 created successfully");
	}
	@Test
	public void simple5() {
		System.out.println("supplier3 created successfully");
	}
	
		
	}
