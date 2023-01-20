package onlinePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorldPopulation {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.worldometers.info/world-population/");
		Thread.sleep(1000);
		WebElement data = driver.findElement(By.id("maincounter-wrap"));
		String text = data.getText();
		System.out.println(text);
		Thread.sleep(1000);
		driver.close();
		
		

	}

}
