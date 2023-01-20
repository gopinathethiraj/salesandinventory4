package com.sis.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	//Declaration
	@FindBy(name="firstname")
	private WebElement firstnameTextfield;
	
	@FindBy(name="lastname")
	private WebElement lastnameTextfield;
	
	@FindBy(name="phonenumber")
	private WebElement phonenumberTextfield;
	
	@FindBy(xpath="(//button[text()='Save'])[1]")
	private WebElement savebutton;
	
	@FindBy(linkText = "Reset")
	private WebElement reset;
	
	@FindBy(linkText = "Cancel")
	private WebElement Cancel;
	
	//initialization
	
	public AddCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//utilization

	public WebElement getFirstnameTextfield() {
		return firstnameTextfield;
	}

	public WebElement getLastnameTextfield() {
		return lastnameTextfield;
	}

	public WebElement getPhonenumberTextfield() {
		return phonenumberTextfield;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

	public WebElement getReset() {
		return reset;
	}

	public WebElement getCancel() {
		return Cancel;
	}
	
	//Business library
	
	public void firstnametextfield (String firstname, String lastname, String phonenumber) {
		firstnameTextfield.sendKeys(firstname);
		lastnameTextfield.sendKeys(lastname);
		phonenumberTextfield.sendKeys(phonenumber);
	}
		
		public void savebutton() {
			savebutton.click();
	}
	 
	
	
	
	
	
}
