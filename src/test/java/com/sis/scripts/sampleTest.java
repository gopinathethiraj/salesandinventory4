package com.sis.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.WebDriverUtility;

public class sampleTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Gopinath%20E/Desktop/dropdown.html");
		WebElement drop = driver.findElement(By.xpath("//select"));
WebDriverUtility webLib = new WebDriverUtility();
String visible = "hello2";
webLib.select(visible, drop);

	}

}
