package GenericPackageforSalesandInventory;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

public class CustomerandPOSdependency {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		
		 //Random ran= new Random();
		//int random = ran.nextInt(500);
	
	
	
	    //step1: Get Common Data
	String url = fLib.readDataFromPropertyFile("url");
	String username = fLib.readDataFromPropertyFile("username");
	String password = fLib.readDataFromPropertyFile("password");
	String browser = fLib.readDataFromPropertyFile("browser");
	
//FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
//	Properties p = new Properties();
//	p.load(fis);
//	String url = p.getProperty("url");
//	String username = p.getProperty("username");
//	String password = p.getProperty("password");
	
	   //step2: Read Data from excel sheet
//	String firstname = eLib.readDataFromExcel("Add_Customer",0,1);
	
//	FileInputStream fi= new FileInputStream("C:\\Users\\Gopinath E\\Desktop\\excel001.xlsx");
//	Workbook wb = WorkbookFactory.create(fi);
//	Sheet sh = wb.getSheet("Sheet4");
	
	   //step3: Launch the browser
	WebDriver driver = null;
	if(browser.equalsIgnoreCase("firefox")) {
		driver = new FirefoxDriver();
	}
	else if (browser.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
	}
	else
	{
		System.out.println("Browser is invalid");
		
	}
	wLib.maximizeWindow(driver);
	driver.get(url);
	wLib.waitForPageLoad(driver);
	
	//login to application
	driver.findElement(By.name("user")).sendKeys("unguardable");
	driver.findElement(By.name("password")).sendKeys("admin");
	driver.findElement(By.xpath("//button[text()='Login']")).click();
	Alert a= driver.switchTo().alert();
	a.accept();
	
	//clicking customer
	driver.findElement(By.xpath("//span[text()='Customer']")).click();
	driver.findElement(By.xpath("//a[@class='btn btn-primary bg-gradient-primary']")).click();
	//read data from excel file
	Thread.sleep(2000);
	String firstname = eLib.readDataFromExcel("Sheet6", 0, 1);
	String lastname = eLib.readDataFromExcel("Sheet6",1,1);
	String phonenumber = eLib.readDataFromExcel("Sheet6",2,1);
	
	driver.findElement(By.name("firstname")).sendKeys(firstname);
	driver.findElement(By.name("lastname")).sendKeys(lastname);
	driver.findElement(By.name("phonenumber")).sendKeys(phonenumber);
	
	driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='POS']")).click();
	driver.findElement(By.xpath("//a[text()='Monitor']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//form[@action='pos.php?action=add&id=271']/div//input[@name=\"addpos\"]")).click();
	Thread.sleep(1000);
	WebElement option = driver.findElement(By.xpath("//select[@name=\"customer\"]"));
	//WebElement option = null;
	Select s=new Select(option);
	List<WebElement> op = s.getOptions();
	String actual = "karan kumar";
	boolean swag=false;
	for(WebElement noofop:op)
	{
		if(noofop.getText().equals(actual)) {
			noofop.click();
			swag=true;
			break;
		}
		}
	if(swag)
		System.out.println("project created");
	else
		System.out.println("project is not created");
	}
	
	
	

	}


