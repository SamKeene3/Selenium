package phpTravels;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BookHotel {

	WebDriver driver;

	@BeforeClass
	public static void initial() {
		System.out.println("Begin Automated Test");
	}
	@AfterClass
	public static void end() {
		System.out.println("End Automated Test");
	}
	@Before
	public void setup() {
		System.out.println("Start Chrome");
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
	}
	@After
	public void tearDown() throws InterruptedException {
		System.out.println("Closing Chrome");
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void seleniumTest() throws InterruptedException {
		WebElement webElement;
		List<WebElement> listWebElement;
		System.out.println("Selenium Test");
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/m-hotels");

		Actions action = new Actions(driver);

		listWebElement = driver.findElements(By.tagName("div"));
		for (WebElement webele : listWebElement) {
			try {
				webele = webele.findElement(By.tagName("input"));
				webele.sendKeys("London");
				System.out.println("Destination");
				Thread.sleep(1000);
				action.sendKeys(Keys.TAB).perform();
				Thread.sleep(1000);
				action.sendKeys("11/12/2018").perform();
				System.out.println("Chcek-In");
				Thread.sleep(1000);
				action.sendKeys(Keys.TAB).perform();
				Thread.sleep(1000);
				action.sendKeys("13/12/2018").perform();
				System.out.println("Check-out");
				break;
			} catch (Exception e) {

			}
		}
		
		// 
		webElement = driver.findElement(By.id("travellersInput"));
		webElement.click();
		webElement = driver.findElement(By.id("adultPlusBtn"));
		webElement.click();
		Thread.sleep(2000);
		webElement.submit();
		Thread.sleep(2000);

		
			// Find title Attribute from list
		int i = 1;
		listWebElement = driver.findElements(By.className("row"));
		for (WebElement webele : listWebElement) {
			try {
				webele = webele.findElement(By.tagName("a"));
				System.out.println(Integer.toString(i) + ": " + webele.getAttribute("title"));
				i++;
			} catch (Exception e) {

			}
		}
		Thread.sleep(2000);
	}

}
