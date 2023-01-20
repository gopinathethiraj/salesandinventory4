package com.sis.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;

public class AddSupplierPage {
	//Declaration
		@FindBy(name="companyname")
		private WebElement companynameTextfield;
		
		@FindBy(xpath = "(//select[@id='province'])[1]")
		private WebElement provincedropdown;
		
		@FindBy(xpath = "(//select[@id='city'])[1]")
		private WebElement citydropdown;
		
		@FindBy(name="phonenumber")
		private WebElement phonenumberTextfield;
		
		@FindBy(xpath ="(//button[@type=\"submit\"])[1]")
		private WebElement savebutton;
		
		@FindBy(linkText = "Reset")
		private WebElement reset;
		
		@FindBy(linkText = "Cancel")
		private WebElement Cancel;
		
		//initialization
		
		public AddSupplierPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		// utilization
		
        public WebElement getCompanynameTextfield() {
			return companynameTextfield;
		}

		public WebElement getProvincedropdown() {
			return provincedropdown;
		}

		public WebElement getCitydropdown() {
			return citydropdown;
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
		// Business library
		
		public void companynametextfield (String companyname,String albay, String city, String phonenumber,  WebDriverUtility webLib) throws InterruptedException {
		     
			companynameTextfield.sendKeys(companyname);
			provincedropdown.click();
			Thread.sleep(2000);
		     webLib.select(albay, provincedropdown);
		     Thread.sleep(2000);
		     citydropdown.click();
		     Thread.sleep(2000);
		     webLib.select(city, citydropdown);
		     
		     
		     phonenumberTextfield.sendKeys(phonenumber);
		     
		}
		
		
		
		public void savebutton() {
			savebutton.click();
	}

		
	 
	

}
