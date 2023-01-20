package GenericPackageforSalesandInventory;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

public class AddingemployeeAndsearch {

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
	
	//clicking employee
	driver.findElement(By.xpath("//span[text()='Employee']")).click();
	driver.findElement(By.xpath("(//a[@type=\"button\"])[1]")).click();
	Thread.sleep(2000);
	//read data from excel
	String firstname = eLib.readDataFromExcel("Sheet9",0,1);
	String lastname = eLib.readDataFromExcel("Sheet9",1,1);
	String selectgender = eLib.readDataFromExcel("Sheet9",2,1);
	String email = eLib.readDataFromExcel("Sheet9",3,1);
	String phonenumber = eLib.readDataFromExcel("Sheet9",4,1);
	String selectjob = eLib.readDataFromExcel("Sheet9",5,1);
	String province = eLib.readDataFromExcel("Sheet9", 6, 1);
	String city = eLib.readDataFromExcel("Sheet9",7,1);
	
	
	//program
	driver.findElement(By.xpath("(//input[@name=\"firstname\"])[3]")).sendKeys(firstname);
	driver.findElement(By.xpath("(//input[@name=\"lastname\"])[3]")).sendKeys(lastname);
	WebElement act = driver.findElement(By.name("gender"));
	wLib.select(selectgender,act);
	driver.findElement(By.xpath("(//input[@name=\"email\"])[1]")).sendKeys(email);
	driver.findElement(By.xpath("(//input[@class=\"form-control\"])[10]")).sendKeys(phonenumber);
	WebElement tom = driver.findElement(By.xpath("(//select[@class=\"form-control\"])[2]"));
	wLib.select(selectjob,tom);
	driver.findElement(By.id("FromDate")).click();
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_TAB);
	r.keyPress(KeyEvent.VK_2);
	r.keyPress(KeyEvent.VK_8);
	r.keyPress(KeyEvent.VK_1);
	r.keyPress(KeyEvent.VK_2);
	r.delay(3000);
	r.keyPress(KeyEvent.VK_2);
	r.keyPress(KeyEvent.VK_0);
	r.keyPress(KeyEvent.VK_2);
	r.keyPress(KeyEvent.VK_2);
	WebElement provincedropdown = driver.findElement(By.name("province"));
	wLib.select(province, provincedropdown);
	WebElement citydropdown = driver.findElement(By.name("city"));
	wLib.select(city, citydropdown);
	driver.findElement(By.xpath("(//button[@type=\"submit\"])[3]")).click();
	driver.findElement(By.xpath("//input[@type=\"search\"]")).sendKeys("raj");
	
	

	}

}
