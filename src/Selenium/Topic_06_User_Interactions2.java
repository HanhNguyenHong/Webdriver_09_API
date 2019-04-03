package Selenium;

import java.util.List;
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

public class Topic_06_User_Interactions2 {

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
	public void TC_1_Hover_Mouse() throws Exception {	
	    /*
		 * Test Script 01: Move mouse to element
		 Step 01 - Truy cập vào trang: http://www.myntra.com/
		 Step 02 - Hover chuột vào Menu để login
		 Step 03 - Chọn Login button
		 Step 04 - Verify Login form được hiển thị
		 */       
      driver.get("http://www.myntra.com/");
    //Hover profile
      WebElement profileIcon = driver.findElement(By.xpath("//span[@class='myntraweb-header-sprite desktop-iconUser sprites-headerUser']"));	
      action.moveToElement(profileIcon).perform();
      Thread.sleep(3000);
    //Click button
      WebElement loginButton = driver.findElement(By.xpath("//a[contains(text(),'log in')]"));
      loginButton.click();
    //Verify Login form được hiển thị
      Assert.assertTrue(driver.findElement(By.xpath("//div[@class='login-box']")).isDisplayed());	
    }
	@Test
	public void TC_2_Click_and_HoldElement() {
		  /*
		   * Test Script 02: Click and hold element - select multiple item
		 Step 01 - Truy cập vào trang: http://jqueryui.com/resources/demos/selectable/display-grid.html
		 Step 02 - Click and hold từ 1-> 4
		 Step 03 - Sau khi chọn kiểm tra rằng có đúng 4 phần tử đã được chọn thành công với xpath:
		    //li[@class='ui-state-default ui-selectee ui-selected']
		   */
		  driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");
		//Click and hold từ 1-> 4
		List<WebElement> numberItems = driver.findElements(By.xpath("//li[@class='ui-sate-default ui-selectee ui-selected']"));
		
		
		
	}
	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}