package PracticePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Addinguseraccounts {

	public static void main(String[] args) throws IOException, InterruptedException {
		Random ran=new Random();
		int random =ran.nextInt(500);
		
		
		//step1: Get common data
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password= p.getProperty("password");
		
		//step2: Read data from excel sheet
		FileInputStream fi= new FileInputStream("C:\\Users\\Gopinath E\\Desktop\\excel001.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Sheet2");
		String USER = sh.getRow(0).getCell(1).getStringCellValue();
		String PWD = sh.getRow(1).getCell(1).getStringCellValue();
		String empId = sh.getRow(4).getCell(0).getStringCellValue();
		
		
		//String Supplier = sh.getRow(1).getCell(1).getStringCellValue()+random;
		
		WebDriver driver=new ChromeDriver();
	 	driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Login to App
		driver.findElement(By.name("user")).sendKeys("unguardable");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		Alert a= driver.switchTo().alert();
		a.accept();
		//Add user accounts
		driver.findElement(By.xpath("//span[text()='Accounts']")).click();
		driver.findElement(By.xpath("(//a[@class=\"btn btn-primary bg-gradient-primary\"])[2]")).click();
		
		
	Thread.sleep(3000);
	WebElement tiger = driver.findElement(By.name("empid"));
	Select s=new Select(tiger);
	s.selectByVisibleText(empId);
	Thread.sleep(2000);
	
	ArrayList<String> list = new ArrayList<String>();
	list.add("username");
	list.add("password");
	System.out.println(sh.getLastRowNum());
	for(int i=0;i<sh.getLastRowNum();i++) {
		String value = sh.getRow(i).getCell(0).getStringCellValue();
		driver.findElement(By.name(list.get(i))).sendKeys(value);
		}
	Thread.sleep(3000);	
	driver.findElement(By.xpath("(//form[@role='form'])[5]/div[2]/input[@name='username']")).sendKeys(USER);
	driver.findElement(By.xpath("(//form[@role='form'])[5]/div[3]/input[@name='password']")).sendKeys(PWD);
	 
		
	driver.findElement(By.xpath("(//button[@class=\"btn btn-success\"])[5]")).click(); 
	
		
		
		
	}

}
