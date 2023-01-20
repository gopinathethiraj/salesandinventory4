package GenericPackageforSalesandInventory;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

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

public class CreatingproductAndsearch {

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
	//clicking product
	driver.findElement(By.xpath("//span[text()='Product']")).click();
	driver.findElement(By.xpath("//a[@type=\"button\"]")).click();
	Thread.sleep(4000);
	Map<String,String> text = eLib.getList("Sheet8",0,1);
	System.out.println(text);
	driver.findElement(By.name("prodcode")).sendKeys(text.get("prodcode"));
	driver.findElement(By.name("name")).sendKeys(text.get("name"));
	driver.findElement(By.xpath("//textarea[@name=\"description\"]")).sendKeys("selling the hp mouse");
	driver.findElement(By.name("quantity")).sendKeys(text.get("quantity"));
	driver.findElement(By.name("onhand")).sendKeys(text.get("onhand"));
	driver.findElement(By.name("price")).sendKeys(text.get("price"));
	WebElement ele = driver.findElement(By.name("category"));
	wLib.select("Mouse", ele);
	WebElement cat = driver.findElement(By.name("supplier"));
	wLib.select("HP", cat);
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_TAB);
	r.keyPress(KeyEvent.VK_3);
	r.keyPress(KeyEvent.VK_0);
	r.keyPress(KeyEvent.VK_1);
	r.keyPress(KeyEvent.VK_2);
	r.delay(3000);
	r.keyPress(KeyEvent.VK_2);
	r.keyPress(KeyEvent.VK_0);
	r.keyPress(KeyEvent.VK_2);
	r.keyPress(KeyEvent.VK_2);
	
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//button[text()='Save'])[5]")).click();
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//input[@type='search']")).sendKeys("HP");
	
	}
	
	
	
	
	
	
	

	}


