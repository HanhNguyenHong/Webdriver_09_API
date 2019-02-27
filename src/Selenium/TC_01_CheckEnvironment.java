package Selenium;			
			
import org.testng.annotations.Test;			
			
			
import org.testng.annotations.BeforeTest;			
			
import java.util.concurrent.TimeUnit;			
			
import org.openqa.selenium.WebDriver;			
import org.openqa.selenium.firefox.FirefoxDriver;			
import org.testng.Assert;			
import org.testng.annotations.AfterTest;			
			
public class TC_01_CheckEnvironment {			
WebDriver driver;			
			
@BeforeTest			
public void beforeTest() {			
	driver = new FirefoxDriver();		
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
	driver.manage().window().maximize();		
	driver.get("http://live.guru99.com/");		
			
}			
			
@Test			
public void TC_01_checkUrl() {			
	String homePageUrl = driver.getCurrentUrl();		
	Assert.assertEquals(homePageUrl,"http://live.guru99.com/");		
			
}			
@Test			
public void TC_01_checkTitle() {			
	String homePageTitle = driver.getTitle();		
	Assert.assertEquals(homePageTitle,"Home page");		
}			
			
@AfterTest			
public void afterTest() {			
	driver.quit();		
}			
			
}			
			
			
			
			
			
			
			