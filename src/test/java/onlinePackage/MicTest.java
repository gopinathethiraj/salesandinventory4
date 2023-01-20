package onlinePackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MicTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mictests.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Click here to allow access to microphone identifiers']")).click();
		Thread.sleep(2000);
		 driver.switchTo().alert();
		 driver.switchTo().alert().getText();
		 driver.switchTo().alert().accept();
		 Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Test my mic']")).click();

	}

}
