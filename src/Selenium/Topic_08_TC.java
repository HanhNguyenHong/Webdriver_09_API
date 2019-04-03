package Selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Topic_08_TC {
  WebDriver driver;
  JavascriptExecutor Javascript;
    @BeforeTest
    public void beforeTest() {
  	  driver = new FirefoxDriver();
  	 Javascript = (JavascriptExecutor) driver;
  	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
	@Test
public void TC_00_Simple() throws Exception {
	driver.get("https://daominhdam.github.io/basic-form/index.html");
	String parentID = driver.getWindowHandle();
	System.out.println("Parent ID = " + parentID);

	// Click vào Here Link
	driver.findElement(By.xpath("//a[text()='Click Here']")).click();
	Thread.sleep(3000);

	// Get ra tất cả ID của các cửa sổ đang có
	Set<String> allWindows = driver.getWindowHandles();

	// Switch vào window khác vs parent
	for (String childID : allWindows) {
		System.out.println("ID = " + childID);
		if (!childID.equals(parentID)) {
			driver.switchTo().window(childID);
			Thread.sleep(3000);
			break;
		}
	}
	
	Assert.assertEquals(driver.getTitle(), "Google");

	// Switch về parent
	for (String childID : allWindows) {
		System.out.println("ID = " + childID);
		if (childID.equals(parentID)) {
			driver.switchTo().window(childID);
			Thread.sleep(3000);
			break;
		}
	}
	
	Assert.assertEquals(driver.getTitle(), "SELENIUM WEBDRIVER FORM DEMO");
	}
@AfterTest
public void afterTest() {
	driver.quit();
}
}