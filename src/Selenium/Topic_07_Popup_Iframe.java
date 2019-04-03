package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Topic_07_Popup_Iframe {
  WebDriver driver;
  JavascriptExecutor Javascript;
    @BeforeTest
    public void beforeTest() {
  	  driver = new FirefoxDriver();
  	 Javascript = (JavascriptExecutor) driver;
  	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
	@Test
	public void TC_01() throws Exception {
  /*
   * 
  */
		driver.get("http://www.hdfcbank.com/");
	
		//Khai báo notificationiframe	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List <WebElement> notificationiframe = driver.findElements(By.xpath("//iframe[@id='vizury-notification-template']"));
	    int notificationiframeSize = notificationiframe.size();
	    System.out.println("Notification iframe displayed = " + notificationiframe.size());
	    // Size >= nó có xuất hiện
	     if(notificationiframeSize > 0 ) {
	        //SwitchIframe  
			driver.switchTo().frame(notificationiframe.get(0));
	        //Verify img hiển thị  
		     Assert.assertTrue(driver.findElement(By.xpath("//div[@id='container-div']/img")).isDisplayed());	
	  
		    //Close popup 
	          Javascript.executeAsyncScript("arguments[0].click()", driver.findElement(By.xpath("//div[@id='div-close']")));
		       System.out.println("Close popup success");
		          //Switch về Top Windows (Parnent)
	              driver.switchTo().defaultContent();
	             }
	           System.out.println("Pass handle popup");
	          
       //Swich qua iframe chứa text
	        WebElement lookingForIframe = driver.findElement(By.xpath("//div[@class='flipBannerWrap']//iframe"));
	        driver.switchTo().frame(lookingForIframe);
	   //Verify text 
	       Assert.assertTrue(driver.findElement(By.xpath("//span[@id='messageText'and text()='What are you looking for?']")).isDisplayed());
	  

	}
	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}