package PracticePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginModule {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String browser = p.getProperty("browser");
		String username = p.getProperty("username");
		String string = p.getProperty("password");
		
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("user")).sendKeys("unguardable");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		Alert a= driver.switchTo().alert();
		a.accept();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Prince Ly Cesar']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@class=\"dropdown-item\"])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();

	}

}
