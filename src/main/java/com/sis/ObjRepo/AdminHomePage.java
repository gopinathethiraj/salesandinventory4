package com.sis.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	//Declaration
	
	@FindBy(xpath = "//span[text()= 'Customer']")
	private WebElement customer;
	
	@FindBy(xpath = "//span[text()= 'Employee']")
	private WebElement employee;
	
	@FindBy(xpath = "//span[text()='Product']")
	private WebElement product;
	
	@FindBy(xpath = "//span[text()='Inventory']")
	private WebElement inventory;
	
	@FindBy(xpath = "//span[text()='Transaction']")
	private WebElement transaction;
	
	@FindBy(xpath = "//span[text()='Supplier']")
	private WebElement supplier;
	
	@FindBy(xpath = "//span[text()='Accounts']")
	private WebElement accounts;
	
	@FindBy(xpath = "//span[text()='POS']")
	private WebElement POS;
	
	@FindBy(xpath = "//a[@id='userDropdown']")
	private WebElement adminMenuOption;
	
	@FindBy(xpath = "//a[@data-toggle='modal']")
	private WebElement  logout;
	
	@FindBy(linkText = "Logout")
	private WebElement logOutPopup;
	
	//initialization
	public AdminHomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//utilization

	public WebElement getCustomer() {
		return customer;
	}

	public WebElement getEmployee() {
		return employee;
	}

	public WebElement getProduct() {
		return product;
	}

	public WebElement getInventory() {
		return inventory;
	}

	public WebElement getTransaction() {
		return transaction;
	}

	public WebElement getSupplier() {
		return supplier;
	}

	public WebElement getAccounts() {
		return accounts;
	}

	public WebElement getPOS() {
		return POS;
	}

	public WebElement getAdminMenuOption() {
		return adminMenuOption;
	}

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getLogOutPopup() {
		return logOutPopup;
	}
	
	//Business Library
	public void customerModule() {
		customer.click();
	}
	public void employeeModule() {
		employee.click();
	}
	public void productModule() {
		product.click();
	}
	public void transactionModule() {
		transaction.click();
	}
	public void supplierModule() {
		supplier.click();
	}
	public void accountsModule() {
		accounts.click();
	}
	public void POSModule() {
		POS.click();
	}
	public void logoutModule() {
		adminMenuOption.click();
		logout.click();
		logOutPopup.click();

		
	}
	
	

}
