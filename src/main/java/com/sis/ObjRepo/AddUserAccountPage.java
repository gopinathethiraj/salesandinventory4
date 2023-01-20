package com.sis.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;

public class AddUserAccountPage {
	
             @FindBy(xpath = "//select[@name='empid']")
		     private WebElement employeeTF;
             
             @FindBy(xpath = "(//input[@name='username'])[2]" )
             private WebElement usernameTF;
             
             @FindBy(xpath = "(//input[@name='password'])[2]")
             private WebElement passwordTF;
             
             @FindBy(xpath ="(//button[@type=\"submit\"])[5]")
             private WebElement savebutton;
             
           //initialization
     		
     		public AddUserAccountPage(WebDriver driver) {
     			PageFactory.initElements(driver,this);
     		}
           //utilization
     		
			public WebElement getEmployeeTF() {
				return employeeTF;
			}

			public WebElement getUsernameTF() {
				return usernameTF;
			}

			public WebElement getPasswordTF() {
				return passwordTF;
			}

			public WebElement getSavebutton() {
				return savebutton;
			}
			
			//business library
			public void enteruseraccountdetails(String username,String password, WebDriverUtility wLib) {
				wLib.select(employeeTF, 4);
				usernameTF.sendKeys(username);
				passwordTF.sendKeys(password);
				savebutton.click();
				}
				
				
     		
     		
     		
		     
		     
				
				

	}


