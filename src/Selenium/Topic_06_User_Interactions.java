package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Topic_06_User_Interactions {

    WebDriver driver;
    Actions action;


    @BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver","./Resource/geckodriver.exe");
		FirefoxProfile ffprofile = new FirefoxProfile();
		ffprofile.setPreference("dom.webnotifications.enabled", false);
		driver = new FirefoxDriver(ffprofile);
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_Hover_Mouse() throws Exception {

		driver.get("https://www.myntra.com/");
		WebElement profileIcon, logInButton,logInForm;
		profileIcon = driver.findElement(By.xpath("//span[@class='myntraweb-header-sprite desktop-iconUser sprites-headerUser']"));
		logInButton = driver.findElement(By.xpath("//a[text()='log in']"));
		logInForm = driver.findElement(By.xpath("//div[@class='login-box']"));
		
		action.moveToElement(profileIcon).perform();
		Thread.sleep(3000);
		logInButton.click();				
		Assert.assertTrue(logInForm.isDisplayed());
	}
    @Test
	public void TC_02_Hover_Mouse() throws Exception {
    	
    	
    	
    	
    	
    	
    }
	
	
	
	
	
	
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}