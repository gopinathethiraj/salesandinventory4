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
import org.openqa.selenium.chrome.ChromeDriver;

public class Adminaddingemployee {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Random ran=new Random();
		int random =ran.nextInt(500);
		
		
		//step1: Get common data
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String string = p.getProperty("password");
		
		//step2: Read data from excel sheet
		FileInputStream fi= new FileInputStream("C:\\Users\\Gopinath E\\Desktop\\excel001.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Sheet3");
		
		
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
		//Adding Employee		
				driver.findElement(By.xpath("//span[text()='Employee']")).click();
				driver.findElement(By.xpath("(//a[@type=\"button\"])[1]")).click();
				
				ArrayList<String> list = new ArrayList<String>();
				list.add("firstname");
				list.add("lastname");
				list.add("selectgender");
				list.add("email");
				list.add("selectjob");
				list.add("selectprovince");
				list.add("selectcity");
			System.out.println(sh.getLastRowNum());
			for(int i=0;i<=sh.getLastRowNum();i++) {
			String value = sh.getRow(i).getCell(1).toString();
			driver.findElement(By.name(list.get(i))).sendKeys(value);
			}
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//form[@role='form'])[3]/div[1]/input[@name=\"firstname\"]"));
			driver.findElement(By.xpath("(//form[@role='form'])[3]/div[2]/input[@name=\"lastname\"]"));
				
				
				
		

	}

}
