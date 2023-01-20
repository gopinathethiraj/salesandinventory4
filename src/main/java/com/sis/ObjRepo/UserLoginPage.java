package com.sis.ObjRepo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {
	//Declaration
	@FindBy(name="user")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(name="btnlogin")
	private WebElement loginButton;
	
	//initialization
	 public UserLoginPage(WebDriver driver) {
	 PageFactory.initElements(driver,this);
	}
    //utilization
	 
	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	// Business Library
	public void LoginPage(String Username,String Password, WebDriver driver) {
	
		username.sendKeys(Username);
		password.sendKeys(Password);
		loginButton.click();
		driver.switchTo().alert().accept();
	}
		
	
	 
	

}
