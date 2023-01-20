package com.sis.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;

public class ProductPage {
	
	//Declaration
	
	@FindBy(xpath = "//h4[contains(text(),'Product')]/..//a[@data-toggle='modal']")
	private WebElement addproductbutton;
	
	@FindBy(xpath = "//input[@type=\"search\"]")
	private WebElement search;
	
	@FindBy(name="dataTable_length")
	private WebElement entries;
	
	@FindBy(xpath = "//a[text()='Next']")
	private WebElement next;
	
	//initialization
	
		public ProductPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		
	//utilization

		public WebElement getAddproductbutton() {
			return addproductbutton;
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
		
		public void addproductbuttonModule() {
			addproductbutton.click();
		}
		
		public void searchfirstname(String name) {
			search.sendKeys(name);
		}
		
		public void searchlastname(String productcode) {
			search.sendKeys(productcode);
		}
		
		public void searchprice(String price) {
			search.sendKeys(price);
		}
		
		public void searchcategory(String category) {
			search.sendKeys(category);
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
