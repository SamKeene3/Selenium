package com.qa.SeleniumTesting;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Suite.class)
@Suite.SuiteClasses({ TestLogin.class, TestLogout.class, TestNavigation.class,
		TestUpdate.class })

public class TestSuite {
	
	ChromeDriver driver;
	String url;
	
	@Before
	public void setup() {
	System.setProperty("webdriver.chrome.driver","C:/Users/Admin/Desktop/chromedriver.exe");
	driver = new ChromeDriver(); 
	driver.manage().window().maximize();
	url = "https://www.phptravels.net/";
	}
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void elementtest() {
		driver.get(url);
		
		List<WebElement> listOfWebElements = driver.findElements(By.xpath("//*[@id=\"body-section\"]/div[5]/div/div[3]/div[1]/div/table/tbody/tr[1]/td/div[2]/div/a/text()"));
		
		for (WebElement element : listOfWebElements) {
			
			System.out.println("The text for the element is " + element.getText() + "London");
			
		
	}
}

}
