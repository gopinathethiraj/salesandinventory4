package com.sis.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;

public class CustomerPage {
	//Declaration
	
	@FindBy(xpath = "//a[@type=\'button\']")
	private WebElement addcustomerbutton;
	
	@FindBy(xpath = "//input[@type=\'search\']")
	private WebElement search;
	
	@FindBy(name="dataTable_length")
	private WebElement entries;
	
	@FindBy(xpath ="//a[text()='Next']")
	private WebElement next;
	
	//initialization
	public CustomerPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
     
	//utilization
	
	public WebElement getButton() {
		return addcustomerbutton;
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
	
	//Business Library
	
	public void addcustomerbuttonModule() {
		addcustomerbutton.click();
	}
	
	public void searchfirstname(String firstname) {
		search.sendKeys(firstname);
	}
	
	public void searchlastname(String lastname) {
		search.sendKeys(lastname);
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
