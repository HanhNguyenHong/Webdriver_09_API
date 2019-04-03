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

public class Topic_08_Windowas_Tabs2 {
  WebDriver driver;
  JavascriptExecutor Javascript;
private WebDriver diver;
    @BeforeTest
      public void beforeTest() {
  	  driver = new FirefoxDriver();
  	  Javascript = (JavascriptExecutor) driver;
  	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      }
	@Test
	public void TC_01() throws Exception{
			driver.get("https://daominhdam.github.io/basic-form/index.html");
		   
			String parentID = driver.getWindowHandle();
		    System.out.println("Parent ID = " + parentID);	 
			driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
	  		switchToChildWindowID(parentID);  
	    
	        String googleTitle = diver.getTitle();
	  		System.out.println(googleTitle);	    
	  		Assert.assertEquals(googleTitle, "Google");
     }  
     @AfterTest
      public void afterTest() {
	                driver.quit();
	                }
    //Swich if only have 2 windows/ tabs 
	  public void switchToChildWindowID(String parent) {
				 //Lấy ra ID của các cửa số đang mở    
				  Set<String> allWindows = driver.getWindowHandles();
				//Dùng vòng lặp để quyệt qua từng cửa sổ mở
				  for (String runWindow : allWindows) {
				//Kiểm tra nếu ID của cửa sổ khác với ID parent thì swich qua               
		 		  if (!runWindow.equals(parent)) {
	   			 //Swich qua cửa số đó  
				   driver.switchTo().window(runWindow);
	   			 //Thoát khỏi
				    break;
	      				     }
	    	 		    }
					}
	  public void switchToWindowByTitle(String title) {
	                 Set<String> allWindows = driver.getWindowHandles();
	                 for (String runWindows : allWindows) {
	                 driver.switchTo().window(runWindows);
	                 String currentWin = driver.getTitle();
	                 if (currentWin.equals(title)) {
	                 break;
	                     }
	                   }
	                 }    	   
	  public boolean closeAllWithoutParentWindows(String parentWindow) {
	                 Set<String> allWindows = driver.getWindowHandles();
	                 for (String runWindows : allWindows) {
	                 if (!runWindows.equals(parentWindow)) {
	                 driver.switchTo().window(runWindows);
	                 driver.close();
	                   }
	                 }
	                //Khi nó chỉ còn duy nhất 1 cửa sổ-> swich qua
	                 driver.switchTo().window(parentWindow);
	                 if (driver.getWindowHandles().size() == 1)
	                      return true;
	                 else
	                      return false;
	 				    }      
  				     }
  