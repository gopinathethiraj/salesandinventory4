package com.sis.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;

public class SupplierPage {
	// Declaration
	@FindBy(xpath = "//h4[contains(text(),'Supplier')]/..//a[@data-toggle='modal']")
	private WebElement addsupplierbutton;
	
	@FindBy(xpath = "//input[@type=\"search\"]")
	private WebElement search;
	
	@FindBy(name="dataTable_length")
	private WebElement entries;
	
	@FindBy(xpath = "//a[text()='Next']")
	private WebElement next;
	
	//initialization
	
		public SupplierPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
    //utilization

		public WebElement getAddsupplierbutton() {
			return addsupplierbutton;
		}

		public WebElement getSearch() {
			return search;
		}

		public WebElement getEntries() {
			return entries;
		}

		public WebElement getNext() {
			return next;
		}
	//Business library
		public void addsupplierbuttonModule() {
			addsupplierbutton.click();
		}
		
		public void searchcompanyname(String companyname) {
			search.sendKeys(companyname);
		}
		
		public void searchprovince(String province) {
			search.sendKeys(province);
		}
		
		public void searchcity(String city) {
			search.sendKeys(city);
		}
		
		public void searchphonenumber(String phonenumber) {
			search.sendKeys(phonenumber);
		}
		
		public void showentries(WebDriverUtility wLib) {
			wLib.select(entries,0);
		}
		
		public void showentries1(WebDriverUtility wLib) {
			wLib.select(entries,1);
		}
		
		public void showentries2(WebDriverUtility wLib) {
			wLib.select(entries,2);
		}
		
		public void showentries3(WebDriverUtility wLib) {
			wLib.select(entries,3);
		}
		
		public void next() {
			next.click();
		}
		

}
