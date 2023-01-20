package com.sis.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;

public class AccountsPage {
	//Declaration
	@FindBy(xpath = "//h4[contains(text(),'User Accounts')]/..//a[@data-toggle='modal']")
	private WebElement adduseraccounts;
	
	@FindBy(xpath = "//input[@type=\"search\"]")
	private WebElement search;
	
	@FindBy(name="dataTable_length")
	private WebElement entries;
	
	@FindBy(id ="dataTable_next")
	private WebElement next;
	
	//initialization
	public AccountsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
    //utilization
	public WebElement getAdduseraccounts() {
		return adduseraccounts;
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
	// Business library
	
	public void accountsModule() {
		adduseraccounts.click();
	}
	
	public void searchname(String name) {
		search.sendKeys(name);
	}
	
	public void username(String username) {
		search.sendKeys(username);
	}
	
	public void searchtype(String type) {
		search.sendKeys(type);
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
	
}
	

	
