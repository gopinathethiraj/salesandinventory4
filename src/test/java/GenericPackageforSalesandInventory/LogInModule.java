package GenericPackageforSalesandInventory;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

public class LogInModule {

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
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='Home']")).click();
	driver.findElement(By.xpath("(//span[@class=\"mr-2 d-none d-lg-inline text-gray-600 small\"])[2]")).click();
	driver.findElement(By.xpath("(//a[@class=\"dropdown-item\"])[2]")).click();
	driver.findElement(By.xpath("(//a[@class=\"btn btn-primary\"])[1]")).click();
	

	}

}
