package com.sis.ObjRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;

public class AddProductPage {
	@FindBy(name="prodcode")
	private WebElement prodcodeTextfield;
	
	@FindBy(name="name")
	private WebElement nameTextfield;
	
	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement descriptionTextfield;
	
	@FindBy(name="quantity")
	private WebElement quantityTextfield;
	
	@FindBy(name="onhand")
	private WebElement onhandTextfield;
	
	@FindBy(name="price")
	private WebElement priceTextfield;
	
	@FindBy(name="category")
	private WebElement categoryTextfield;
	
	@FindBy(name="supplier")
	private WebElement supplierTextfield;
	
	@FindBy(name="datestock")
	private WebElement dateTextfield;
	
	@FindBy(xpath ="(//button[@type=\"submit\"])[5]")
	private WebElement savebutton;
	
	@FindBy(linkText = "Reset")
	private WebElement reset;
	
	@FindBy(linkText = "Cancel")
	private WebElement Cancel;
	
	//initialization
	
	public AddProductPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
    //utilization
	
	public WebElement getProdcodeTextfield() {
		return prodcodeTextfield;
	}

	public WebElement getNameTextfield() {
		return nameTextfield;
	}

	public WebElement getDescriptionTextfield() {
		return descriptionTextfield;
	}

	public WebElement getQuantityTextfield() {
		return quantityTextfield;
	}

	public WebElement getOnhandTextfield() {
		return onhandTextfield;
	}

	public WebElement getPriceTextfield() {
		return priceTextfield;
	}

	public WebElement getCategoryTextfield() {
		return categoryTextfield;
	}

	public WebElement getSupplierTextfield() {
		return supplierTextfield;
	}

	public WebElement getDateTextfield() {
		return dateTextfield;
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
	public void enterProductdetails(String prodcode,String name,String description,String quantity,String onhand,String price,  WebDriverUtility wLib) {
		prodcodeTextfield.sendKeys(prodcode);
		nameTextfield.sendKeys(name);
		descriptionTextfield.sendKeys(description);
		quantityTextfield.sendKeys(quantity);
		onhandTextfield.sendKeys(onhand);
		priceTextfield.sendKeys(price);
		wLib.select("Keyboard",categoryTextfield);
		wLib.select("apple",supplierTextfield);
		dateTextfield.click();
		dateTextfield.sendKeys("01/02/2023");
		savebutton.click();
	}
		//dateTextfield.sendKeys();
		//savebutton.click();
		
	}
	
	


