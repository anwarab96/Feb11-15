package com.februaryeleven15;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AjaxFour_WebDriver {
	private WebDriver driver;
	private String baseUrl;
	int vSleep;
	@BeforeMethod
	public void setUp(){
		driver = new FirefoxDriver();
		baseUrl="http://www.kayak.com/";
		vSleep= 2000;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void test() throws Exception{
		driver.navigate().to(baseUrl);
		driver.findElement(By.id("wherebox")).clear();
		Thread.sleep(vSleep);
		driver.findElement(By.id("wherebox")).sendKeys("Los A");
		Thread.sleep(vSleep);
		System.out.println("The city is " + driver.findElement(By.id("city-16078-1118")).getText());
		Thread.sleep(vSleep);
		String sp1= "//html/body/div[10]/ul/li[";
		String sp2= "]";
		String sp3;
		for(int i=1; i<11; i++){
			sp3=sp1+ i + sp2;
			System.out.println("Ajax list " + i + " is " + driver.findElement(By.xpath(sp3)).getText());
		}
	}
	
}
