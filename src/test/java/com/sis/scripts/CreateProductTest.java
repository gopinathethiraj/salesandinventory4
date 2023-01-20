package com.sis.scripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;
import com.sis.ObjRepo.AddCustomerPage;
import com.sis.ObjRepo.AddProductPage;
import com.sis.ObjRepo.AdminHomePage;
import com.sis.ObjRepo.AdminLoginPage;
import com.sis.ObjRepo.ProductPage;

public class CreateProductTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		   
		String url = fLib.readDataFromPropertyFile("url");
		String username = fLib.readDataFromPropertyFile("username");
		String password = fLib.readDataFromPropertyFile("password");
		String browser = fLib.readDataFromPropertyFile("browser");
		
		   
		
		WebDriver driver = new ChromeDriver();
		
		wLib.maximizeWindow(driver);
		driver.get(url);
		wLib.waitForPageLoad(driver);
		
		AdminLoginPage lp = new AdminLoginPage(driver);
		lp.LoginPage(username, password, driver);
		
		AdminHomePage hp = new AdminHomePage(driver);
		hp.productModule();
		
		ProductPage pp = new ProductPage(driver);
		pp.addproductbuttonModule();
		
		AddProductPage cus= new AddProductPage(driver);
		
		String prodcode = eLib.readDataFromExcel("Sheet1",0,1)+jLib.getRandomNo();
		String name = eLib.readDataFromExcel("Sheet1",1,1)+jLib.getRandomNo();
		String description= eLib.readDataFromExcel("Sheet1",2,1)+jLib.getRandomNo();
		String quantity = eLib.readDataFromExcel("Sheet1",3,1)+jLib.getRandomNo();
		String onhand = eLib.readDataFromExcel("Sheet1",4,1)+jLib.getRandomNo();
		String price = eLib.readDataFromExcel("Sheet1",5,1)+jLib.getRandomNo();
		cus.enterProductdetails(prodcode, name,description, quantity, onhand, price, wLib);
		cus.getCategoryTextfield();
		cus.getSupplierTextfield();
		cus.getDateTextfield().click();
		
		
		
		
		/*Thread.sleep(1000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.keyPress(KeyEvent.VK_0);
		r.keyRelease(KeyEvent.VK_0);
		
		r.keyPress(KeyEvent.VK_1);
		r.keyRelease(KeyEvent.VK_1);
		
		r.keyPress(KeyEvent.VK_0);
		r.keyRelease(KeyEvent.VK_0);
		
		r.keyPress(KeyEvent.VK_2);
		r.keyRelease(KeyEvent.VK_2);
		
		r.keyPress(KeyEvent.VK_2);
		r.keyRelease(KeyEvent.VK_2);
		
		r.keyPress(KeyEvent.VK_0);
		r.keyRelease(KeyEvent.VK_0);
		
		r.keyPress(KeyEvent.VK_2);
		r.keyRelease(KeyEvent.VK_2);
		
		r.keyPress(KeyEvent.VK_3);
		r.keyRelease(KeyEvent.VK_3);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		*/
		
		

	}

}
